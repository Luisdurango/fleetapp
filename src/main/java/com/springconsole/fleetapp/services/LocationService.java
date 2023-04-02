package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Location;
import com.springconsole.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public List<Location> getLocation(){
        return locationRepository.findAll();
    }
    //Save new location
    public void save(Location location){
        locationRepository.save(location);
    }

    //Get by id
    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        locationRepository.deleteById(id);
    }
}
