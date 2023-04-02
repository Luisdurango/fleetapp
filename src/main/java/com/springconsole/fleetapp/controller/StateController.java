package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.models.State;
import com.springconsole.fleetapp.services.CountryService;
import com.springconsole.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class StateController {

    @Autowired
    StateService stateService;

    @Autowired
    CountryService countryService;

    @GetMapping("/state")
    public String getState(Model model){

        List<State> stateList = stateService.getState();
        model.addAttribute("state",stateList);

        List<Country> contryList = countryService.getCountries();
        model.addAttribute("country", contryList);

        return "state";
    }
    @PostMapping("/state/addNew")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/state";
    }
    @RequestMapping("state/findById")
    @ResponseBody
    public Optional<State> findById(Integer id){
        return stateService.findById(id);

    }

    @RequestMapping(value = "state/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(State state){
        stateService.save(state);
        return "redirect:/state";
    }
    @RequestMapping(value = "state/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        stateService.delete(id);
        return "redirect:/state";
    }
}