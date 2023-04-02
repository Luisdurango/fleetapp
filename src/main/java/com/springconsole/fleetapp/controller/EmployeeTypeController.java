package com.springconsole.fleetapp.controller;

import org.springframework.ui.Model;
import com.springconsole.fleetapp.models.EmployeeType;
import com.springconsole.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    EmployeeTypeService employeeTypeService;


    @GetMapping("/employee-type")
    public String getEmployeetype(Model model){

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeType();
        model.addAttribute("employeeType",employeeTypeList);
                               
        return "employee-type";
        
    }

    @PostMapping("/employee-type/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employee-type";
    }
    @RequestMapping("employee-type/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id){
        return employeeTypeService.findById(id);

    }

    @RequestMapping(value = "employee-type/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType){

        employeeTypeService.save(employeeType);
        return "redirect:/employee-type";
    }
    @RequestMapping(value = "employee-type/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employee-type";
    }
}
