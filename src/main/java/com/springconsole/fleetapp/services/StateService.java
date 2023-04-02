package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.State;
import com.springconsole.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    public List<State> getState(){
        return stateRepository.findAll();
    }
    //Save new state
    public void save(State state){
        stateRepository.save(state);
    }

    //Get by id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

    //Get only State id and name
    public List<State>getNameid(){
        return stateRepository.findNameid();
    }
}
