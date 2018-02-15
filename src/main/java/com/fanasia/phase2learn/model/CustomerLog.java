package com.fanasia.phase2learn.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;


@Entity
@Table(name = "customer_log")
public class CustomerLog {

    @Id
    @Column(name = "log_id", updatable = false, nullable = false)
    private String id;

    @Column(name = "log")
    private String log;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
