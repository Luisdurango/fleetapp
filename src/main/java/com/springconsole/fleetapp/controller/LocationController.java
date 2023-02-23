package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.models.Location;
import com.springconsole.fleetapp.models.State;
import com.springconsole.fleetapp.services.CountryService;
import com.springconsole.fleetapp.services.LocationService;
import com.springconsole.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;

    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    @GetMapping("/location")
    public String getLocation(Model model){

        List<Location> locationList = locationService.getLocation();
        model.addAttribute("location",locationList);

        List<Country> contryList = countryService.getCountries();
        model.addAttribute("country", contryList);

        List<State> stateList = stateService.getState();
        model.addAttribute("state", stateList);

        return "location";
    }
    @PostMapping("/location/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/location";
    }
    @RequestMapping("location/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id){
        return locationService.findById(id);

    }

    @RequestMapping(value = "location/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){

        locationService.save(location);
        return "redirect:/location";
    }
    @RequestMapping(value = "location/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/location";
            }
    }

