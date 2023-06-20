package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "restaurants")
public class Restaurante {
    @Id
    private String id;

    @Field("rest_name")  // Nombre del campo ajustado
    private String restName;

    @Field("rest_address")  // Nombre del campo ajustado
    private String restAddress;

    @Field("rest_opening_hours")  // Nombre del campo ajustado
    private String restOpeningHours;

    @Field("owners")
    private List<Owner> owners;

    @Field("invoices")
    private List<Invoice> invoices;

    @Field("customer_reservations")
    private List<CustomerReservation> customerReservations;

    @Field("menu")
    private List<MenuItem> menu;

    @Field("accesses")
    private List<Access> accesses;

    @Field("customer_orders")
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
