package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Contact;
import com.springconsole.fleetapp.models.User;
import com.springconsole.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser(){
        return "user";
    }

    @PostMapping("/user/addNew")
    public String addNew(@ModelAttribute User user, BindingResult result, @RequestParam("profile_picture") MultipartFile file) throws IOException {

        if(result.hasErrors()){return "Error!";}
        String fileName = file.getOriginalFilename();
        user.setProfilePicture(fileName);
        userService.save(user);

        Path uploadDir = Paths.get("/resources/static/assets/img/user-photos");
        Path filePath = uploadDir.resolve(fileName);

        try (InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file: " + fileName, e);
        }

        return "redirect:/user";
    }
}
