package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Supplier;
import com.springconsole.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    public List<Supplier> getSupplier(){
        return supplierRepository.findAll();
    }
    //Save new Supplier
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    //Get by id
    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        supplierRepository.deleteById(id);
    }
}
