package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.VehicleType;
import com.springconsole.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }
    //Save new VehicleType
    public void save(VehicleType VehicleType){
        vehicleTypeRepository.save(VehicleType);
    }

    //Get by id
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleTypeRepository.deleteById(id);
    }
}
