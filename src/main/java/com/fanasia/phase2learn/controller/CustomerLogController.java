package com.fanasia.phase2learn.controller;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.model.CustomerLog;
import com.fanasia.phase2learn.request.RegisterLogRequest;
import com.fanasia.phase2learn.service.CustomerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer/{customerId}/logs")
public class CustomerLogController
{
    @Autowired
    private CustomerLogService customerLogService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerLog register(@PathVariable long customerId, @Valid @RequestBody RegisterLogRequest request){
        return customerLogService.addLog(request.getLog(), customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerLog getLog(@PathVariable long customerId, @PathVariable long id) {
        return customerLogService.getLog(id, customerId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CustomerLog> getAllLogs(@PathVariable long customerId) {
        return customerLogService.getAllLogs(customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean deleteLog(@PathVariable long customerId, @PathVariable long id) {
        return customerLogService.deleteLog(id, customerId);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerLog editLog(@PathVariable long customerId, @PathVariable long id, @RequestBody RegisterLogRequest request) {
        Customer customer = new Customer();
        CustomerLog logs = new CustomerLog();

        customer.setId(customerId);

        logs.setId(id);
        logs.setLog(request.getLog());
        logs.setCustomer(customer);

        return customerLogService.editLog(logs);
    }
}
