package com.fanasia.phase2learn.repo;

import com.fanasia.phase2learn.model.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerLogRepository extends JpaRepository<CustomerLog, String> {

    List<CustomerLog> findAllByCustomerId(String customerId);
    CustomerLog findLogByIdAndCustomerId(String id, String customerId);
    boolean existsLogByIdAndCustomerId(String id, String customerId);
    void deleteLogByIdAndCustomerId(String id, String customerId);
}
