package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Vehicle;
import com.springconsole.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService { 
    @Autowired
    VehicleRepository vehicleService;

    public List<Vehicle> getVehicle(){
        return vehicleService.findAll();
    }
    //Save new Vehicle
    public void save(Vehicle vehicle){
        vehicleService.save(vehicle);
    }

    //Get by id
    public Optional<Vehicle> findById(int id){
        return vehicleService.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleService.deleteById(id);
    }

    public List<Vehicle> getOnlyId(){return vehicleService.getOnlyId();}
}
