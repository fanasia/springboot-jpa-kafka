package com.fanasia.phase2learn.repo;

import com.fanasia.phase2learn.model.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerLogRepository extends JpaRepository<CustomerLog, Long> {

    List<CustomerLog> findAllByCustomerId(long customerId);
    CustomerLog findLogByIdAndCustomerId(long id, long customerId);
    boolean existsLogByIdAndCustomerId(long id, long customerId);
    void deleteLogByIdAndCustomerId(long id, long customerId);
}
