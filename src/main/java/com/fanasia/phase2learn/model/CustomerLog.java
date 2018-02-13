package com.fanasia.phase2learn.model;

import javax.persistence.*;


@Entity
@Table(name = "customer_log")
public class CustomerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private long id;

    @Column(name = "log")
    private String log;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
