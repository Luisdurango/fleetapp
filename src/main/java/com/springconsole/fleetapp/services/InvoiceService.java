package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Invoice;
import com.springconsole.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    public List<Invoice> getInvoice(){
        return invoiceRepository.findAll();
    }
    //Save new Invoice
    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    //Get by id
    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        invoiceRepository.deleteById(id);
    }
}
