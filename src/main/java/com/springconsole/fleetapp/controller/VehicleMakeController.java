package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.VehicleMake;
import com.springconsole.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    VehicleMakeService vehicleMakeService;


    @GetMapping("/vehicle-make")
    public String getInvoicestatus(Model model){

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMake();
        model.addAttribute("vehicleMake",vehicleMakeList);


        return "vehicle-make";
    }

    @PostMapping("/vehicle-make/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle-make";
    }
    @RequestMapping("vehicle-make/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id){
        return vehicleMakeService.findById(id);

    }

    @RequestMapping(value = "vehicle-make/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){

        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle-make";
    }
    @RequestMapping(value = "vehicle-make/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicle-make";
    }
}
