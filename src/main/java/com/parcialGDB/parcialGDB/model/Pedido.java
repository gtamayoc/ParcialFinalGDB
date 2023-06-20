package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;

public class Pedido {
    @Id
    private String _id;
    private int cantidad;
    private Producto producto;
}
