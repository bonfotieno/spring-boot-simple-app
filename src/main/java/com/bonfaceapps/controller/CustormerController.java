package com.bonfaceapps.controller;

import com.bonfaceapps.DTO.*;
import com.bonfaceapps.entity.Customer;
import com.bonfaceapps.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustormerController {


    private final CustomerRepository customerRepository;

    public CustormerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping  // the getting data items from the database
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }


    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){  // @RequestBody captures the request data and saves it to NewCustomerRequest
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}") // you must use DELETE method in the client side
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    // edit or update we use PutMapping
    @PutMapping("{customerId}")
    public void UpdateCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setAge(request.getAge());
        customerRepository.save(customer);
    }
}
