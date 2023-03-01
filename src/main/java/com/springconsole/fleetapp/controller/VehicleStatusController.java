package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.VehicleStatus;
import com.springconsole.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    VehicleStatusService vehicleStatusService;


    @GetMapping("/vehicle-status")
    public String getInvoicestatus(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehicleStatus",vehicleStatusList);


        return "vehicle-status";
    }

    @PostMapping("/vehicle-status/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle-status";
    }
    @RequestMapping("vehicle-status/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id){
        return vehicleStatusService.findById(id);

    }

    @RequestMapping(value = "vehicle-status/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){

        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle-status";
    }
    @RequestMapping(value = "vehicle-status/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicle-status";
    }
}
