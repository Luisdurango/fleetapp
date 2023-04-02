package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.VehicleModel;
import com.springconsole.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    VehicleModelService vehicleModelService;


    @GetMapping("/vehicle-model")
    public String getInvoicestatus(Model model){

        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModel();
        model.addAttribute("vehicleModel",vehicleModelList);


        return "vehicle-model";
    }

    @PostMapping("/vehicle-model/addNew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle-model";
    }
    @RequestMapping("vehicle-model/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id){
        return vehicleModelService.findById(id);

    }

    @RequestMapping(value = "vehicle-model/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel){

        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle-model";
    }
    @RequestMapping(value = "vehicle-model/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehicle-model";
    }
}
