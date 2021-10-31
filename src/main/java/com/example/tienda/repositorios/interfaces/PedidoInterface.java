package com.example.tienda.repositorios.interfaces;

import com.example.tienda.modelos.Pedido;
import com.example.tienda.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface PedidoInterface extends CrudRepository<Pedido, Integer> {
}
