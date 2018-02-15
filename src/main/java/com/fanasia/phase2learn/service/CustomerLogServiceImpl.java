package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.model.CustomerLog;
import com.fanasia.phase2learn.repo.CustomerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerLogServiceImpl implements CustomerLogService{

    @Autowired
    CustomerLogRepository customerLogRepository;

    @Override
    public CustomerLog addLog(String log, String customerId) {
        Customer customer = new Customer();
        CustomerLog logs = new CustomerLog();

        customer.setId(customerId);

        logs.setId(UUID.randomUUID().toString());
        logs.setLog(log);
        logs.setCustomer(customer);

        return customerLogRepository.save(logs);
    }

    @Override
    public CustomerLog getLog(String id, String customerId) {
        return customerLogRepository.findLogByIdAndCustomerId(id, customerId);
    }

    @Override
    public List<CustomerLog> getAllLogs(String customerId) {
        return customerLogRepository.findAllByCustomerId(customerId);
    }

    @Override
    public boolean deleteLog(String id, String customerId) {
        boolean isSuccess = true;

        try {
            customerLogRepository.deleteLogByIdAndCustomerId(id, customerId);
        }
        catch (Exception e) {
            isSuccess = false;
        }

        return isSuccess;
    }

    @Override
    public CustomerLog editLog(CustomerLog logs) {
        if(customerLogRepository.existsLogByIdAndCustomerId(logs.getId(), logs.getCustomer().getId())) {
            return customerLogRepository.save(logs);
        }
        else {
            return null;
        }
    }
}
