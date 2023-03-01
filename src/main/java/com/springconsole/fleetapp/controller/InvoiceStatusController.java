package com.springconsole.fleetapp.controller;

import com.springconsole.fleetapp.models.InvoiceStatus;
import com.springconsole.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    InvoiceStatusService invoiceStatusService;
   
   
    @GetMapping("/invoice-status")
    public String getInvoicestatus(Model model){

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatus",invoiceStatusList);
        
        
        return "invoice-status";
    }

    @PostMapping("/invoice-status/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice-status";
    }
    @RequestMapping("invoice-status/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id){
        return invoiceStatusService.findById(id);

    }

    @RequestMapping(value = "invoice-status/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){

        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice-status";
    }
    @RequestMapping(value = "invoice-status/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoice-status";
    }
    
    
    
}
