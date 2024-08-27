package com.sev.shop.Controller;
import com.sev.shop.Customer;
import com.sev.shop.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired
    private CustomerService customerService;
  @PostMapping
    public static Customer addCustomer(@RequestBody Customer customer){
      return CustomerService.addCustomer(customer);
  }


}
