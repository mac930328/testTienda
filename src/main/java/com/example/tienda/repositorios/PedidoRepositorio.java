package com.example.tienda.repositorios;

import com.example.tienda.modelos.Pedido;
import com.example.tienda.repositorios.interfaces.PedidoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositorio {

    @Autowired
    private PedidoInterface crud;

    public List<Pedido> obtenerTodos() {
        return (List<Pedido>) crud.findAll();
    }

    public Optional<Pedido> obtenerId(int codigo) {
        return crud.findById(codigo);
    }

    public Pedido guardarActualizar(Pedido pedido) {
        return crud.save(pedido);
    }

    public void eliminar(Pedido pedido) {
        crud.deleteById(pedido.getOrden());
    }
}
