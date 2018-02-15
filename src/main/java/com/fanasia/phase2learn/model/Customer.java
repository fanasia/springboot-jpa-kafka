package com.fanasia.phase2learn.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @Column(name = "customer_id", updatable = false, nullable = false)
    private String id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerLog> customerLogs = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CustomerLog> getCustomerLogs() {
        return customerLogs;
    }

    public void setCustomerLogs(List<CustomerLog> customerLogs) {
        this.customerLogs = customerLogs;
    }

    public void addLog(CustomerLog customerLog) {
        this.customerLogs.add(customerLog);
    }

    public CustomerLog removeLog(String id) {
        int index = this.customerLogs.indexOf(id);
        return index != -1 ? customerLogs.remove(index) : null;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
