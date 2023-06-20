package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Factura {
    @Id
    private String _id;
    private Date fact_fecha;
    private double fact_total;
    private double fact_descuento;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getFact_fecha() {
        return fact_fecha;
    }

    public void setFact_fecha(Date fact_fecha) {
        this.fact_fecha = fact_fecha;
    }

    public double getFact_total() {
        return fact_total;
    }

    public void setFact_total(double fact_total) {
        this.fact_total = fact_total;
    }

    public double getFact_descuento() {
        return fact_descuento;
    }

    public void setFact_descuento(double fact_descuento) {
        this.fact_descuento = fact_descuento;
    }
}
