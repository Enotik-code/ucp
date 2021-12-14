package com.example.sweater.controller;

import com.example.sweater.domain.Company;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class CompanyController {

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping(value = {"/rendCompany"})
    public String getDataForChangeCompany(@AuthenticationPrincipal User user, Model model){
        Company company = companyRepo.findByUser_Id(user.getId());
        model.addAttribute("company", company);
        return "rendCompany";
    }

    @PostMapping("/rendCompany")
    public String changeCompany( @AuthenticationPrincipal User user,
                                 @RequestParam String name,
                                 @RequestParam String address,
                                 @RequestParam String mail,
                                 @RequestParam String telephone,
                                 @RequestParam String deliveryTimeCoefficient,
                                 @RequestParam String deliveryCostCoefficient,
                                 Model model)
            throws IOException {

        Company company = new Company(name, address, mail, telephone, Double.parseDouble(deliveryTimeCoefficient), Double.parseDouble(deliveryCostCoefficient),  user);
        companyRepo.updateCompanyName(user.getId(), company.getName());
        company = companyRepo.findByUser_Id(user.getId());
        model.addAttribute("company", company);

        return "company";
    }


    @GetMapping("/company")
    public String main(@AuthenticationPrincipal User user, Model model, HttpSession session) {
        Company company = companyRepo.findByUser_Id(user.getId());

        session.setAttribute("company", company);
        model.addAttribute("company", company);
        return "company";
    }

    @GetMapping("/delCompany")
    public String delete(@AuthenticationPrincipal User user, Model model){
        Company company = companyRepo.findByUser_Id(user.getId());
        companyRepo.deleteById(company.getId());  //удаляем компанию
        model.addAttribute("company", company);

        return "redirect:/company";
    }

    @PostMapping("/company")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String mail,
            @RequestParam String telephone,
            @RequestParam String deliveryTimeCoefficient,
            @RequestParam String deliveryCostCoefficient,
            Model model ) throws IOException {

        Company company = new Company(name, address, mail, telephone, Double.parseDouble(deliveryTimeCoefficient), Double.parseDouble(deliveryCostCoefficient),  user);
        companyRepo.save(company);
        company = companyRepo.findByUser_Id(user.getId());
        model.addAttribute("company", company);

        return "company";
    }
}
