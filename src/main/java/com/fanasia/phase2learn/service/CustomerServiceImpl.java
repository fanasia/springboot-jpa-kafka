package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.model.CustomerLog;
import com.fanasia.phase2learn.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer register(String firstName, String lastName, String log) {
        CustomerLog logs = new CustomerLog();
        Customer customer = new Customer();

        logs.setId(UUID.randomUUID().toString());
        logs.setLog(log);

        customer.setId(UUID.randomUUID().toString());
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.addLog(logs);

        return repository.save(customer);
    }

    @Override
    public Customer findCustomerById(String id) {
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
    public boolean deleteCustomer(String id) {
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
