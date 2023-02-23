package com.springconsole.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VehicleMakeController {
    @GetMapping("/vehicle-make")
    public String getVehiclemake(){
        return "vehicle-make";
    }
}
