package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Reserva {
    @Id
    private String _id;
    private Date fecha_reserva;
    private String descripcion_reserva;

}
