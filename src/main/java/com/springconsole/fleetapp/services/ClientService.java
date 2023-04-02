package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getClient(){
        return clientRepository.findAll();
    }
    //Get only client id and name for invoice country
    public List<Client> getClientNameid(){
        return clientRepository.findNameid();
    }

    //Save new Client
    public void save(Client Client){
        clientRepository.save(Client);
    }

    //Get by id
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
