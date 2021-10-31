package com.example.tienda.repositorios.interfaces;

import com.example.tienda.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoInterface extends CrudRepository<Producto, Integer> {
}
