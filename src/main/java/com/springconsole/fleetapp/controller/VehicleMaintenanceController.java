package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Supplier;
import com.springconsole.fleetapp.models.VehicleMaintenance;
import com.springconsole.fleetapp.services.SupplierService;
import com.springconsole.fleetapp.services.VehicleMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {
    @Autowired
    VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    SupplierService supplierService;


    @GetMapping("/vehicle-maintenance")
    public String getEmployeetype(Model model){

        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenance();
        model.addAttribute("vehicleMaintenance",vehicleMaintenanceList);

        List<Supplier> supplierList= supplierService.getSupplier();
        model.addAttribute("supplier", supplierList);

         VehicleMaintenance vehicleMaintenanceObj = new VehicleMaintenance();
         model.addAttribute("vehicleMaintenanceObj", vehicleMaintenanceObj);

//        List<Vehicle> vehicleList = vehicleService.getVehicle();
//        model.addAttribute("vehicle",vehicleList);

        return "vehicle-maintenance";

    }

    @PostMapping("/vehicle-maintenance/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle-maintenance";
    }
    @RequestMapping("vehicle-maintenance/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id){
        return vehicleMaintenanceService.findById(id);

    }

    @RequestMapping(value = "vehicle-maintenance/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance){

        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle-maintenance";
    }
    @RequestMapping(value = "vehicle-maintenance/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicle-maintenance";
    }
}
