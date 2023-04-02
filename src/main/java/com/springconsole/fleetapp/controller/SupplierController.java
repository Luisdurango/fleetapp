package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.models.State;
import com.springconsole.fleetapp.models.Supplier;
import com.springconsole.fleetapp.services.CountryService;
import com.springconsole.fleetapp.services.StateService;
import com.springconsole.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @Autowired
    CountryService countryService;

    @Autowired
    StateService stateService;


    @GetMapping("/supplier")
    public String getEmployeetype(Model model){

        List<Supplier> supplierList = supplierService.getSupplier();
        model.addAttribute("supplier",supplierList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("country",countryList);

        List<State> stateList = stateService.getState();
        model.addAttribute("state",stateList);


        return "supplier";

    }

    @PostMapping("/supplier/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/supplier";
    }
    @RequestMapping("supplier/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id){
        return supplierService.findById(id);

    }

    @RequestMapping(value = "supplier/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){

        supplierService.save(supplier);
        return "redirect:/supplier";
    }
    @RequestMapping(value = "supplier/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        supplierService.delete(id);
        return "redirect:/supplier";
    }
}
