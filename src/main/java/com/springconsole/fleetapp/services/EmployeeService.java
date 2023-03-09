package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Employee;
import com.springconsole.fleetapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    //Save new Employee
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    //Get by id
    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
