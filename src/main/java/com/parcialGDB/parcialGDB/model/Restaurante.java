package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "restaurants")
public class Restaurante {
    @Id
    private String id;
    private String restName;
    private String restAddress;
    private String restOpeningHours;
    private List<Owner> owners;
    private List<Invoice> invoices;
    private List<CustomerReservation> customerReservations;
    private List<MenuItem> menu;
    private List<Access> accesses;
    private List<CustomerOrder> customerOrders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(String restAddress) {
        this.restAddress = restAddress;
    }

    public String getRestOpeningHours() {
        return restOpeningHours;
    }

    public void setRestOpeningHours(String restOpeningHours) {
        this.restOpeningHours = restOpeningHours;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<CustomerReservation> getCustomerReservations() {
        return customerReservations;
    }

    public void setCustomerReservations(List<CustomerReservation> customerReservations) {
        this.customerReservations = customerReservations;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<Access> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
