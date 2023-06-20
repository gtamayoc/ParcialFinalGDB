package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "restaurantes")
public class Acceso {
    @Id
    private String _id;
    private String correo;
    private String clave;
    private List<FechaAcceso> fecha_accesos;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<FechaAcceso> getFecha_accesos() {
        return fecha_accesos;
    }

    public void setFecha_accesos(List<FechaAcceso> fecha_accesos) {
        this.fecha_accesos = fecha_accesos;
    }
}