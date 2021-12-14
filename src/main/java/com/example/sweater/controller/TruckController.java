package com.example.sweater.controller;

import com.example.sweater.calculate.Backpack;
import com.example.sweater.domain.*;
import com.example.sweater.repos.CargoRepo;
import com.example.sweater.repos.CompanyRepo;
import com.example.sweater.repos.DeliveryRepo;
import com.example.sweater.repos.TruckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class TruckController {

    @Autowired
    private TruckRepo truckRepo;

    long comp_id;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private DeliveryRepo deliveryRepo;

    @Autowired
    private CargoRepo cargoRepo;

    private Truck truck;

    @GetMapping("/truck")
    public String main(@RequestParam(required = false, defaultValue = "") String search,
                       @AuthenticationPrincipal User user, Model model) {
        comp_id = companyRepo.findByUser_Id(user.getId()).getId();
        List<Truck> trucks = truckRepo.findByCompany_Id(comp_id);
        if (trucks.size() == 0) trucks = null;
        model.addAttribute("trucks", trucks);
        return "truck";
    }

    @GetMapping("/truckDownload/{truck.id}")
    public String addCompanyToDelivery(@AuthenticationPrincipal User user, @PathVariable(name = "truck.id") String id, Model model) {
        Truck truck = truckRepo.findById(Integer.parseInt(id));
        Company company = companyRepo.findByUser_Id((long)user.getId());
        int finalCost = 0;
        List<Delivery> companyDeliveries = deliveryRepo.findAllByCompany_Id(company.getId());
        if(companyDeliveries.size() > 0){
            Backpack backpack = new Backpack(truck.getLiftingCapacity());
            backpack.makeAllSets(companyDeliveries);
            List<Delivery> finalPackOfDeliveries = backpack.GetBestSet();
            for(Delivery delivery : finalPackOfDeliveries){
                finalCost = finalCost + delivery.getDeliveryCost();
            }
            model.addAttribute("bestset", finalPackOfDeliveries);
            model.addAttribute("capacity", truck.getLiftingCapacity());
            model.addAttribute("cost", finalCost);
        }
        return "backpack";
    }



    @GetMapping(value = {"/truck/{truck.id}"})
    public String delete( @PathVariable(name = "truck.id") String id, Model model) {
        Truck truck = truckRepo.findById(Integer.parseInt(id));
        truckRepo.delete(truck);

        return "redirect:/company";
    }

    @PostMapping("/truck")
    public String add(
            @RequestParam String band,
            @RequestParam String truckModel,
            @RequestParam String plateNumber,
            @RequestParam String liftingCapacity,
            @RequestParam String type,
            Map<String, Object> model,
            @AuthenticationPrincipal User user) {

        comp_id = companyRepo.findByUser_Id(user.getId()).getId();
        Company company = companyRepo.findById(comp_id);
        int doneLiftingCapacity = Integer.parseInt(liftingCapacity);
        Truck truck = new Truck(band, truckModel, plateNumber, doneLiftingCapacity, type, company);
        truckRepo.save(truck);
        Iterable<Truck> trucks = truckRepo.findByCompany_Id(comp_id);

        model.put("trucks", trucks);

        return "redirect:http://localhost:8080/truck";
    }
}
