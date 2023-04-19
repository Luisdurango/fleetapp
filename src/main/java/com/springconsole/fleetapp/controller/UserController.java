package com.springconsole.fleetapp.controller;
import com.springconsole.fleetapp.models.User;
import com.springconsole.fleetapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
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

// Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService newUserService;

    @GetMapping("/user")
    public String getUser(){return "user";}

    @PostMapping("/user/addNew")
    public String addNew(@ModelAttribute User user, @RequestParam("profile-picture") MultipartFile file) throws IOException {

        String fileName = user.getUsername() + '.' +  StringUtils.getFilenameExtension(file.getOriginalFilename());

        // save the file to disk
        Path uploadDir = Paths.get("src/main/resources/static/assets/img/user-photos");
        Path uploadPath = uploadDir.resolve(fileName);
        try (InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save uploaded file: " + fileName, e);
        }

        //Create new user object, since using.save(user) will save the Multipart file and not the .setProfilePicture(fileName)
        User userTest = new User();
        userTest.setFirstName(user.getFirstName());
        userTest.setLastName(user.getLastName());
        userTest.setUsername(user.getUsername());
        userTest.setPassword(user.getPassword());
        userTest.setProfilePicture(fileName);

        // set the file name as the profilePicture field
//        user.setProfilePicture(fileName);

        // save the user
        newUserService.save(userTest);

        return "redirect:/customLogin";
    }
}