package com.sev.shop.Services;
import com.sev.shop.Customer;
import com.sev.shop.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public static Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);

    }
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

}

//updateCustomer: Bir müşteriyi günceller.
//deleteCustomer: Bir müşteriyi siler.