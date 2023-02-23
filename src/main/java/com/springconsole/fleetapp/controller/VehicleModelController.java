package com.springconsole.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VehicleModelController {
    @GetMapping("/vehicle-model")
    public String getVehiclemodel(){
        return "vehicle-model";
    }
}
