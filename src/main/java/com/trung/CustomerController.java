package com.trung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;
      
    @GetMapping("/customers")
    public String listAll(Model model) {
        List<Customer> listCustomers = customerRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);
          
        return "customers";
    }
      
}