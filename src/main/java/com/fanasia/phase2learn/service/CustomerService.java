package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;

import java.util.List;


public interface CustomerService {

    Customer register(String firstName, String lastName);
    Customer getCustomerById(long id);
    List<Customer> getCustomerByLastName(String lastName);
    List<Customer> getAllCustomers();
    boolean deleteCustomer(long id);
    Customer editCustomer(Customer customer);

}
