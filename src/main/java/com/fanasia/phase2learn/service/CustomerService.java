package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;

import java.util.List;


public interface CustomerService {

    Customer register(String firstName, String lastName);
    Customer findCustomerById(long id);
    List<Customer> findCustomerByLastName(String lastName);
    List<Customer> findAllCustomers();
    boolean deleteCustomer(long id);
    Customer editCustomer(Customer customer);

}
