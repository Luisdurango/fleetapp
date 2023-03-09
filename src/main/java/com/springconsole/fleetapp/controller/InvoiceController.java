package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.Invoice;
import com.springconsole.fleetapp.models.InvoiceStatus;
import com.springconsole.fleetapp.services.ClientService;
import com.springconsole.fleetapp.services.InvoiceService;
import com.springconsole.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceStatusService invoiceStatusService;
    @Autowired
    ClientService clientService;


    @GetMapping("/invoice")
    public String getEmployeetype(Model model){

        List<Invoice> invoiceList = invoiceService.getInvoice();
        model.addAttribute("invoice",invoiceList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatus", invoiceStatusList);

        List<Client> clientList = clientService.getClientNameid();
        model.addAttribute("client",clientList);

        Invoice invoice = new Invoice(); // create new invoice object
        model.addAttribute("invoiceObj", invoice); // add invoice object to model

        return "invoice";

    }

    @PostMapping("/invoice/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }
    @RequestMapping("invoice/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id){
        return invoiceService.findById(id);

    }

    @RequestMapping(value = "invoice/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){

        invoiceService.save(invoice);
        return "redirect:/invoice";
    }
    @RequestMapping(value = "invoice/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoice";
    }
}
