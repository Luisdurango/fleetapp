package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.VehicleModel;
import com.springconsole.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    public List<VehicleModel> getVehicleModel(){
        return vehicleModelRepository.findAll();
    }
    //Save new vehicleModel
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    //Get by id
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        vehicleModelRepository.deleteById(id);
    }
}
