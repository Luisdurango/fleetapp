package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.VehicleType;
import com.springconsole.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;


    @GetMapping("/vehicle-type")
    public String getInvoicestatus(Model model){

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
        model.addAttribute("vehicleType",vehicleTypeList);


        return "vehicle-type";
    }

    @PostMapping("/vehicle-type/addNew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle-type";
    }
    @RequestMapping("vehicle-type/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id){
        return vehicleTypeService.findById(id);

    }

    @RequestMapping(value = "vehicle-type/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType){

        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle-type";
    }
    @RequestMapping(value = "vehicle-type/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicle-type";
    }
}
