package com.fanasia.phase2learn.service;

import com.fanasia.phase2learn.model.CustomerLog;

import java.util.List;




public interface CustomerLogService {

    CustomerLog addLog(String log, String customerId);
    CustomerLog getLog(String id, String customerId);
    List<CustomerLog> getAllLogs(String customerId);
    boolean deleteLog(String id, String customerId);
    CustomerLog editLog(CustomerLog logs);
}
