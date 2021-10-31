package com.example.tienda.controladores;

import com.example.tienda.modelos.Producto;
import com.example.tienda.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio repositorio;

    public List<Producto> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Producto> obtenerId(int id) {
        return repositorio.obtenerId(id);
    }

    public Producto guardar(Producto producto) {
        if (producto.getCodigo() == null) {
            return repositorio.guardarActualizar(producto);
        } else {
            Optional<Producto> p = repositorio.obtenerId(producto.getCodigo());
            if (p.isEmpty()) {
                return repositorio.guardarActualizar(producto);
            } else {
                return producto;
            }
        }
    }

    public Producto actualizar(Producto producto) {
        if (producto.getCodigo() != null) {
            Optional<Producto> p = repositorio.obtenerId(producto.getCodigo());
            if (!p.isEmpty()) {
                return repositorio.guardarActualizar(producto);
            } else {
                return producto;
            }
        } else {
            return producto;
        }
    }

    public boolean eliminar(int codigo) {
        return obtenerId(codigo).map(producto -> {
            repositorio.eliminar(producto);
            return true;
        }).orElse(false);
    }
}
