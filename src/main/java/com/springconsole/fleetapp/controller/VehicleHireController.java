package com.springconsole.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VehicleHireController {
    @GetMapping("/vehicle-hire")
    public String getVehiclehire(){
        return "vehicle-hire";
    }

}
