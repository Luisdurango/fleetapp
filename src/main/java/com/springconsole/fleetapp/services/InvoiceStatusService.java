package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.InvoiceStatus;
import com.springconsole.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    public List<InvoiceStatus> getInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }
    //Save new invoiceStatus
    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    //Get by id
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        invoiceStatusRepository.deleteById(id);
    }
}
