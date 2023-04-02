package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.VehicleMaintenance;
import com.springconsole.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;
    public List<VehicleMaintenance> getVehicleMaintenance(){
        return vehicleMaintenanceRepository.findAll();
    }
    //Save new VehicleMaintenance
    public void save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    //Get by id
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleMaintenanceRepository.deleteById(id);
    }
    
}
