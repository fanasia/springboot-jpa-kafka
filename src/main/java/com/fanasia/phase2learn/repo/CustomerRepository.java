package com.fanasia.phase2learn.repo;

import com.fanasia.phase2learn.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);
}
