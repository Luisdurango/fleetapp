package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.VehicleMake;
import com.springconsole.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;
    public List<VehicleMake> getVehicleMake(){
        return vehicleMakeRepository.findAll();
    }
    //Save new vehicleMake
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    //Get by id
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleMakeRepository.deleteById(id);
    }
}
