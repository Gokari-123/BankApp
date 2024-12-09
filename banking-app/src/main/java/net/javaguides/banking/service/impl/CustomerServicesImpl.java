package net.javaguides.banking.service.impl;

import net.javaguides.banking.entity.Customer;
import net.javaguides.banking.repository.CustomersRepository;
import net.javaguides.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerService {

    @Autowired
    CustomersRepository customersRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: \" + id"));
    }
}
