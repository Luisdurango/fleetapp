package com.springconsole.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserProfile {

    @GetMapping("/users-profile")
    public String getUserProfile(){
        return "users-profile";
    }

}
