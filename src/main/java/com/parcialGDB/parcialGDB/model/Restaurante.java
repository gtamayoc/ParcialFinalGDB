package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "nombre_coleccion")
public class Restaurante {
    @Id
    private String id;
    private String rest_nombre;
    private String rest_direccion;
    private String rest_horario_atencion;
    private List<Dueno> duenos;
    private List<Factura> facturas;
    private List<ReservaCliente> reservas_cliente;
    private List<Menu> menu;
    private List<Acceso> accesos;
    private List<PedidoCliente> pedidos_clientes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRest_nombre() {
        return rest_nombre;
    }

    public void setRest_nombre(String rest_nombre) {
        this.rest_nombre = rest_nombre;
    }

    public String getRest_direccion() {
        return rest_direccion;
    }

    public void setRest_direccion(String rest_direccion) {
        this.rest_direccion = rest_direccion;
    }

    public String getRest_horario_atencion() {
        return rest_horario_atencion;
    }

    public void setRest_horario_atencion(String rest_horario_atencion) {
        this.rest_horario_atencion = rest_horario_atencion;
    }

    public List<Dueno> getDuenos() {
        return duenos;
    }

    public void setDuenos(List<Dueno> duenos) {
        this.duenos = duenos;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<ReservaCliente> getReservas_cliente() {
        return reservas_cliente;
    }

    public void setReservas_cliente(List<ReservaCliente> reservas_cliente) {
        this.reservas_cliente = reservas_cliente;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Acceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(List<Acceso> accesos) {
        this.accesos = accesos;
    }

    public List<PedidoCliente> getPedidos_clientes() {
        return pedidos_clientes;
    }

    public void setPedidos_clientes(List<PedidoCliente> pedidos_clientes) {
        this.pedidos_clientes = pedidos_clientes;
    }
}
