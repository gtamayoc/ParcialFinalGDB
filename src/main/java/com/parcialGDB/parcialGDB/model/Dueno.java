package com.parcialGDB.parcialGDB.model;

import java.util.Date;

public class Dueno {
    private String due_nombre;
    private String due_documento;
    private String due_telefono;
    private Date due_fecha_nacimiento;
    private String due_sexo;

    public String getDue_nombre() {
        return due_nombre;
    }

    public void setDue_nombre(String due_nombre) {
        this.due_nombre = due_nombre;
    }

    public String getDue_documento() {
        return due_documento;
    }

    public void setDue_documento(String due_documento) {
        this.due_documento = due_documento;
    }

    public String getDue_telefono() {
        return due_telefono;
    }

    public void setDue_telefono(String due_telefono) {
        this.due_telefono = due_telefono;
    }

    public Date getDue_fecha_nacimiento() {
        return due_fecha_nacimiento;
    }

    public void setDue_fecha_nacimiento(Date due_fecha_nacimiento) {
        this.due_fecha_nacimiento = due_fecha_nacimiento;
    }

    public String getDue_sexo() {
        return due_sexo;
    }

    public void setDue_sexo(String due_sexo) {
        this.due_sexo = due_sexo;
    }
}
