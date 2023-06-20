package com.parcialGDB.parcialGDB.model;

import org.springframework.data.annotation.Id;

public class CustomerOrder {
    @Id
    private String _id;
    private Cliente cliente;
    private Pedido pedido;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
