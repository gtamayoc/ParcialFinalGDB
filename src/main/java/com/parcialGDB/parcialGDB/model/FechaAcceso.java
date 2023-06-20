package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class FechaAcceso {
    @Id
    private String _id;
    private Date fecha_acceso;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getFecha_acceso() {
        return fecha_acceso;
    }

    public void setFecha_acceso(Date fecha_acceso) {
        this.fecha_acceso = fecha_acceso;
    }
}
