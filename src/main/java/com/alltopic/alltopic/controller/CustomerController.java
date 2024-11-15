package com.alltopic.alltopic.controller;

import com.alltopic.alltopic.model.Customer;
import com.alltopic.alltopic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/post")
    public Customer insertDeatils(@RequestBody Customer customer) {
       return  customerService.save(customer);
    }

    @GetMapping("/get")
    public List<Customer> getDetails() {
        return  customerService.findall();
    }

    @PutMapping("/put/{id}")
    public Customer updateDetails (@PathVariable long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDetails(@PathVariable long id) {
         customerService.delete(id);
         return "Deleted";
    }
}
