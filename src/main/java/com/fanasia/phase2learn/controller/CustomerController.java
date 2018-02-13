package com.fanasia.phase2learn.controller;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.request.RegisterCustomerRequest;
import com.fanasia.phase2learn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(
           method = RequestMethod.POST,
           produces = MediaType.APPLICATION_JSON_VALUE,
           consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer registerCustomer(@Valid @RequestBody RegisterCustomerRequest request) {
        return customerService.register(request.getFirstName(), request.getLastName());
    }

    @RequestMapping(
            value = "/id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer getCustomerById(@PathVariable long id) {
        return customerService.findCustomerById(id);
    }

    @RequestMapping(
            value = "/lastname/{lastname}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> getCustomerByLastName(@PathVariable String lastname) {
        return customerService.findCustomerByLastName(lastname);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean deleteCustomer(@PathVariable long id) {
        return customerService.deleteCustomer(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer updateCustomer(@PathVariable long id, @Valid @RequestBody RegisterCustomerRequest request) {
        Customer customer = new Customer(request.getFirstName(), request.getLastName());
        customer.setId(id);

        return customerService.editCustomer(customer);
    }
}
