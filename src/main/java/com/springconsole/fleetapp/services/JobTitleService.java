package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.JobTitle;
import com.springconsole.fleetapp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;
    public List<JobTitle> getJobTitle(){
        return jobTitleRepository.findAll();
    }
    //Save new jobTitle
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    //Get by id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    //Delete by id
    public void delete(Integer id){
        jobTitleRepository.deleteById(id);
    }
}
