package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer register(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);

        return repository.save(customer);
    }

    @Override
    public Customer findCustomerById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Customer> findCustomerByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCustomer(long id) {
        boolean isSuccess = true;

        try {
            repository.delete(id);
        }
        catch (Exception e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    @Override
    public Customer editCustomer(Customer customer) {
        if(repository.exists(customer.getId())) {
            return repository.save(customer);
        }
        else {
            return null;
        }
    }


}
