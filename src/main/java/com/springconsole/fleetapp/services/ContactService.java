package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Contact;
import com.springconsole.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> getContact(){
        return contactRepository.findAll();
    }
    //Save new Contact
    public void save(Contact contact){
        contactRepository.save(contact);
    }

    //Get by id
    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        contactRepository.deleteById(id);
    }
}
