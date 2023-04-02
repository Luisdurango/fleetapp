package com.springconsole.fleetapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/index")
    public String goHome(){

        return "index";
    }
    @GetMapping("/customLogin")
    public String login(){

        return "customLogin";
    }
    @GetMapping("/logout")
    public String logout(){

        return "customLogin";
    }
}
