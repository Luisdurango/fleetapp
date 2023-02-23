package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public List<Country> getCountries(){
    return countryRepository.findAll();
    }
    //Save new country
    public void save(Country country){
        countryRepository.save(country);
    }

    //Get by id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
         countryRepository.deleteById(id);
    }

}
