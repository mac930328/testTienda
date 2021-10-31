package com.example.tienda.repositorios;

import com.example.tienda.modelos.Producto;
import com.example.tienda.repositorios.interfaces.ProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositorio {

    @Autowired
    private ProductoInterface crud;

    public List<Producto> obtenerTodos() {
        return (List<Producto>) crud.findAll();
    }

    public Optional<Producto> obtenerId(int codigo) {
        return crud.findById(codigo);
    }

    public Producto guardarActualizar(Producto producto) {
        return crud.save(producto);
    }

    public void eliminar(Producto producto) {
        crud.deleteById(producto.getCodigo());
    }

}
