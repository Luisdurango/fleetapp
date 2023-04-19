package com.springconsole.fleetapp.web;
import com.springconsole.fleetapp.models.User;
import com.springconsole.fleetapp.models.VehicleMaintenance;
import com.springconsole.fleetapp.services.VehicleMaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplicationController {


    @GetMapping("/index")
    public String goHome(Model model){

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
    @GetMapping("/pages-register")
    public String register(Model model){

        model.addAttribute("user",new User());


        return "/pages-register";
    }
}
