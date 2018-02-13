package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.Customer;
import com.fanasia.phase2learn.model.CustomerLog;
import com.fanasia.phase2learn.repo.CustomerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerLogServiceImpl implements CustomerLogService{

    @Autowired
    CustomerLogRepository customerLogRepository;

    @Override
    public CustomerLog addLog(String log, long customerId) {
        Customer customer = new Customer();
        CustomerLog logs = new CustomerLog();

        customer.setId(customerId);

        logs.setLog(log);
        logs.setCustomer(customer);

        return customerLogRepository.save(logs);
    }

    @Override
    public CustomerLog getLog(long id, long customerId) {
        return customerLogRepository.findLogByIdAndCustomerId(id, customerId);
    }

    @Override
    public List<CustomerLog> getAllLogs(long customerId) {
        return customerLogRepository.findAllByCustomerId(customerId);
    }

    @Override
    public boolean deleteLog(long id, long customerId) {
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
