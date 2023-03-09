package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.*;
import com.springconsole.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;
    @Autowired
    JobTitleService jobTitleService;
    @Autowired
    EmployeeTypeService employeeTypeService;


    @GetMapping("/employee")
    public String getEmployee(Model model){

        List<Employee> employeeList = employeeService.getEmployee();
        model.addAttribute("employee",employeeList);

        List<Country> countryIdDescription = countryService.getNameid();
        model.addAttribute("country", countryIdDescription);

        List<State> stateIdName = stateService.getNameid();
        model.addAttribute("state",stateIdName);

        List<JobTitle> jobTitleList = jobTitleService.getJobTitle();
        model.addAttribute("jobTitle",jobTitleList);

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeType();
        model.addAttribute("employeeType", employeeTypeList);


        //id methods only for id and name retrieval to reduce Stack Overflow Error (country, state, job_title, employee_type)



        //Dates Objects (employeeObj.hireDate, employeeObj.birthDate)
        Employee employee = new Employee();
        model.addAttribute("employeeObj", employee);
        return "employee";

    }

    @PostMapping("/employee/addNew")
    public String addNew(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping("employee/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id){
        return employeeService.findById(id);

    }

    @RequestMapping(value = "employee/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){

        employeeService.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "employee/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
