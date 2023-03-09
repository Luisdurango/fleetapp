package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.EmployeeType;
import com.springconsole.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    public List<EmployeeType> getEmployeeType(){
        return employeeTypeRepository.findAll();
    }
    //Save new EmployeeType
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    //Get by id
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        employeeTypeRepository.deleteById(id);
    }
}
