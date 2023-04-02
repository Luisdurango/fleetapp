package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Contact;
import com.springconsole.fleetapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;


    @GetMapping("/contact")
    public String getEmployeetype(Model model){

        List<Contact> contactList = contactService.getContact();
        model.addAttribute("contact",contactList);

        return "contact";

    }

    @PostMapping("/contact/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }
    @RequestMapping("contact/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id){
        return contactService.findById(id);

    }

    @RequestMapping(value = "contact/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){

        contactService.save(contact);
        return "redirect:/contact";
    }
    @RequestMapping(value = "contact/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        contactService.delete(id);
        return "redirect:/contact";
    }
}
