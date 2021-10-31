package com.example.tienda.controladores;

import com.example.tienda.modelos.Cliente;
import com.example.tienda.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteControlador {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<Cliente> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Cliente> obtenerId(long id) {
        return repositorio.obtenerId(id);
    }

    public Cliente guardar(Cliente cliente) {
        if (cliente.getCedula() == null) {
            return repositorio.guardarActualizar(cliente);
        } else {
            Optional<Cliente> p = repositorio.obtenerId(cliente.getCedula());
            if (p.isEmpty()) {
                return repositorio.guardarActualizar(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente actualizar(Cliente cliente) {
        if (cliente.getCedula() != null) {
            Optional<Cliente> p = repositorio.obtenerId(cliente.getCedula());
            if (!p.isEmpty()) {
                return repositorio.guardarActualizar(cliente);
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }

    public boolean eliminar(long codigo) {
        return obtenerId(codigo).map(producto -> {
            repositorio.eliminar(producto);
            return true;
        }).orElse(false);
    }
}
