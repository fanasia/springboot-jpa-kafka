package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;

import java.util.List;


public interface CustomerService {

    Customer register(String firstName, String lastName, String log);
    Customer findCustomerById(String id);
    List<Customer> findCustomerByLastName(String lastName);
    List<Customer> findAllCustomers();
    boolean deleteCustomer(String id);
    Customer editCustomer(Customer customer);

}
