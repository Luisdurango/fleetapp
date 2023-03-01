package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.JobTitle;
import com.springconsole.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    JobTitleService jobTitleService;


    @GetMapping("/job-title")
    public String getInvoicestatus(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitle();
        model.addAttribute("jobTitle",jobTitleList);


        return "job-title";
    }

    @PostMapping("/job-title/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/job-title";
    }
    @RequestMapping("job-title/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id){
        return jobTitleService.findById(id);

    }

    @RequestMapping(value = "job-title/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){

        jobTitleService.save(jobTitle);
        return "redirect:/job-title";
    }
    @RequestMapping(value = "job-title/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        jobTitleService.delete(id);
        return "redirect:/job-title";
    }
}
