package com.springconsole.fleetapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EmployeeTypeController {
    @GetMapping("/employee-type")
    public String getEmployeetype(){
        return "employee-type";
    }
}
