package com.example.sweater.controller;

import com.example.sweater.domain.*;
import com.example.sweater.repos.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class CargoController {

    @Autowired
    private CargoRepo cargoRepo;

    @GetMapping("/cargo")
    public String main(@AuthenticationPrincipal User user, Model model) {

        List<Cargo> cargos = new ArrayList<>();
        cargos.addAll(cargoRepo.findByUser_Id(user.getId()));
        if(cargos.size() == 0) cargos = null;
        model.addAttribute("cargos", cargos);

        return "cargo";
    }

    @GetMapping(value = {"/cargo/{cargo.id}"})
    public String delete(@PathVariable(name = "cargo.id") String id, Model model) {

        Cargo cargo = cargoRepo.findById(Integer.parseInt(id));
        cargoRepo.delete(cargo);

        return "redirect:http://localhost:8080/cargo";
    }

    @GetMapping(value = {"/delivery/{cargo.id}"})
    public String startDeliveryProcedure(@PathVariable(name = "cargo.id") String id, Model model) {
        model.addAttribute("cargo_id", id);
        System.out.println(model.toString());

        return "redirect:/cargoDelivery";
    }

    @PostMapping("/cargo")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String cost,
            @RequestParam String capacity,
            @RequestParam String weight,
            Model model
    ) throws IOException {

        Cargo cargo = new Cargo(name, Integer.parseInt(cost), Integer.parseInt(capacity), Integer.parseInt(weight), user);
        cargoRepo.save(cargo);
        List<Cargo> cargos = new ArrayList<>();
        cargos.addAll(cargoRepo.findByUser_Id(user.getId()));
        model.addAttribute("cargos", cargos);

        return "redirect:http://localhost:8080/cargo";
    }
}
