package com.example.sweater.controller;


import com.example.sweater.domain.Cargo;
import com.example.sweater.domain.Company;
import com.example.sweater.domain.Delivery;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CargoRepo;
import com.example.sweater.repos.CompanyRepo;
import com.example.sweater.repos.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class DeliveryController {

    @Autowired
    CargoRepo cargoRepo;

    @Autowired
    DeliveryRepo deliveryRepo;

    @Autowired
    CompanyRepo companyRepo;

    private String cargo_id;
    private Delivery delivery;
    private Cargo cargo;

    @GetMapping("/cargoDelivery")
    public String executeDeliveryProcedure(Model model) {
        cargo = cargoRepo.findById(Integer.parseInt(cargo_id));
        model.addAttribute("cargo", cargo);
        return "cargoDelivery";
    }

    @PostMapping("/cargoDelivery")
    public String addDelivery(
            @AuthenticationPrincipal User user,
            @RequestParam String pickupAddress,
            @RequestParam String deliveryAddress,
            @RequestParam String addressPointOne,
            @RequestParam String addressPointTwo,
            @RequestParam String addressPointThree,
            @RequestParam String deliveryType,
            @RequestParam String distance,
            @RequestParam(defaultValue = "false", value = "dangerousCargo") boolean dangerousCargo,
            Model model
            ) throws IOException {

        if(addressPointOne == "") addressPointOne = "qwerty";
        if(addressPointTwo == "") addressPointTwo = "qwerty";
        if(addressPointThree == "") addressPointThree = "qwerty";
        delivery = new Delivery(pickupAddress, deliveryAddress, addressPointOne, addressPointTwo,
                addressPointThree, deliveryType, Integer.parseInt(distance), dangerousCargo, cargo);
        delivery.setUser(user);
        delivery.setCargoName(cargo.getName());
        delivery.setVolume(cargo.getCapacity());
        model.addAttribute("delivery", delivery);
        return "redirect:/carrierChoice"; //добавить редирект на выбор грузоперевозчика
    }

    @GetMapping("/cargoDelivery/{cargo.id}")
    public String startDeliveryProcedure(@PathVariable(name = "cargo.id") String id, Model model) {
        cargo_id = id;
        return "redirect:http://localhost:8080/cargoDelivery";
    }


    @GetMapping("/carrierChoice")
    public String startCarrierChoice(Model model) {
        List<Company> companies = new ArrayList<>();
        companies = companyRepo.findAll();
        int[] deliveryCosts = new int[companies.size()];
        int[] deliveryTimes = new int[companies.size()];
        for(int i = 0; i < companies.size(); i++){   //рассчитываем значения стоимости доставки и времени
            deliveryCosts[i] = (int)(cargo.getCost() * companies.get(i).getDeliveryCostCoefficient() + delivery.getDistance());
            deliveryTimes[i] = (int)((delivery.getDistance()/70)*companies.get(i).getDeliveryTimeCoefficient()) + 2;
        }
        model.addAttribute("companies", companies);
        model.addAttribute("deliveryCosts", deliveryCosts);
        model.addAttribute("deliveryTimes", deliveryTimes);
        return "carrierChoice";
    }

    @GetMapping("/addCompanyToDelivery/{company.id}")
    public String addCompanyToDelivery(@PathVariable(name = "company.id") String id, Model model) {
        Company company = companyRepo.findById(Integer.parseInt(id));
        delivery.setCompany(company);
        delivery.setCompanyName(company.getName());
        delivery.setDeliveryCost((int)(cargo.getCost() * company.getDeliveryCostCoefficient() + delivery.getDistance()));
        delivery.setDeliveryTime((int)((delivery.getDistance()/70)*company.getDeliveryTimeCoefficient()) + 1);
        deliveryRepo.save(delivery);
        cargo.setClose(true);
        cargoRepo.save(cargo);
        return "redirect:http://localhost:8080";
    }

    @GetMapping("/deliveryList")
    public String getDeliveriesData(@AuthenticationPrincipal User user, Model model) {
        List<Delivery> deliveries = deliveryRepo.findAllByUser_Id(user.getId());
        model.addAttribute("deliveries", deliveries);
        return "deliveryList";
    }

    @GetMapping("/getFullInfoDelivery/{delivery.id}")
    public String getDeliveryInfo(@PathVariable(name = "delivery.id") String id, Model model) {
        Delivery delivery = deliveryRepo.findById(Integer.parseInt(id));
        return "deliveryList";
    }


}
