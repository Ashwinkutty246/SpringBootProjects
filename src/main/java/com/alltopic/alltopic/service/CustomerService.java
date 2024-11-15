package com.alltopic.alltopic.service;

import com.alltopic.alltopic.model.Customer;
import com.alltopic.alltopic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findall() {
        return customerRepository.findAll();
    }

    public Customer update(long id, Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        Customer updateCustomer = customer1.get();
        updateCustomer.setCusname(customer.getCusname());
        updateCustomer.setLocation(customer.getLocation());
        updateCustomer.setProduct(customer.getProduct());
        return customerRepository.save(updateCustomer);
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
