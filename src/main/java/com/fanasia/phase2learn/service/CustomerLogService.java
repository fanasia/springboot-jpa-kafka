package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.CustomerLog;

import java.util.List;

public interface CustomerLogService {

    CustomerLog addLog(String log, long customerId);
    CustomerLog getLog(long id, long customerId);
    List<CustomerLog> getAllLogs(long customerId);
    boolean deleteLog(long id, long customerId);
    CustomerLog editLog(CustomerLog logs);
}
