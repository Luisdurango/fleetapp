package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Contact;
import com.springconsole.fleetapp.models.User;
import com.springconsole.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser(){
        return "user";
    }

    @PostMapping("/user/addNew")
    public String addNew(User user){
        userService.save(user);
        return "redirect:/user";
    }
}
