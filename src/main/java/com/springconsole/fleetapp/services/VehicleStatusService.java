package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.VehicleStatus;
import com.springconsole.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusService;
    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusService.findAll();
    }
    //Save new vehicleStatus
    public void save(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
    }

    //Get by id
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleStatusService.deleteById(id);
    }
}
