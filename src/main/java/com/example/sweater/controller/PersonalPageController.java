package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class PersonalPageController {

    @Autowired
    private UserRepo userRepo;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/personalPage")
    public String userStat(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", userRepo.findByUsername(user.getUsername()));
        model.addAttribute("roles", Role.values());
        return "personalPage";
    }

    @PostMapping("/personalPage")
    public String change(
            @AuthenticationPrincipal User user,
            @RequestParam String initials,
            @RequestParam String mail,
            @RequestParam String age,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        //добавить проверок мб, либо на форме
        user.setInitials(initials);
        user.setMail(mail);
        int userAge = Integer.parseInt(age);
        user.setAge(userAge);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            user.setFilename(resultFilename);
        }

        userRepo.save(user);

        return "redirect:/personalPage";
    }



}
