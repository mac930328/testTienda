package com.example.tienda.repositorios.interfaces;

import com.example.tienda.modelos.Cliente;
import com.example.tienda.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ClienteInterface extends CrudRepository<Cliente, Long> {
}
