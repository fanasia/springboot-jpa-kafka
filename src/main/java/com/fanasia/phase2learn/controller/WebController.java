package com.fanasia.phase2learn.controller;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WebController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process() {
        //save a single customer
        repository.save(new Customer("Jack", "Smith"));

        //save a list of customer
        repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Possible")));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";

        for(Customer cust : repository.findAll()) {
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String findByLastName(@RequestParam("lastname") String lastName) {
        String result = "";

        for(Customer cust : repository.findByLastName(lastName)) {
            result += cust.toString() + "<br>";
        }

        return result;
    }


}
