package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.models.State;
import com.springconsole.fleetapp.services.ClientService;
import com.springconsole.fleetapp.services.CountryService;
import com.springconsole.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    StateService stateService;

    @Autowired
    CountryService countryService;


    @GetMapping("/client")
    public String getClient(Model model){

        List<Client> clientList = clientService.getClient();
        model.addAttribute("client",clientList);

        List<State> stateList = stateService.getState();
        model.addAttribute("state",stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("country",countryList);

        return "client";

    }

    @PostMapping("/client/addNew")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/client";
    }
    @RequestMapping("client/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id){
        return clientService.findById(id);

    }

    @RequestMapping(value = "client/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){

        clientService.save(client);
        return "redirect:/client";
    }
    @RequestMapping(value = "client/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        clientService.delete(id);
        return "redirect:/client";
    }
}
