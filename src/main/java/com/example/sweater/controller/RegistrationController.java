package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            User user,
            Map<String, Object> model,
            @RequestParam String select) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (Objects.nonNull(userFromDb)) {
            model.put("message", "User exists!");
            return "registration";
        }

        if (select.equals("Carrier")) {
            user.setRoles(Collections.singleton(Role.ADMIN));
        } else user.setRoles(Collections.singleton(Role.USER));

        user.setActive(true);

        userRepo.save(user);

        return "redirect:/login";
    }
}