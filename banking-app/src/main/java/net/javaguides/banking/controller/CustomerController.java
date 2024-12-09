package net.javaguides.banking.controller;

import net.javaguides.banking.entity.Customer;
import net.javaguides.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomerDetails(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
}
