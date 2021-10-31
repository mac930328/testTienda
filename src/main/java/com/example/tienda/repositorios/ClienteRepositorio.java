package com.example.tienda.repositorios;

import com.example.tienda.modelos.Cliente;
import com.example.tienda.repositorios.interfaces.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio {

    @Autowired
    private ClienteInterface crud;

    public List<Cliente> obtenerTodos() {
        return (List<Cliente>) crud.findAll();
    }

    public Optional<Cliente> obtenerId(long codigo) {
        return crud.findById(codigo);
    }

    public Cliente guardarActualizar(Cliente cliente) {
        return crud.save(cliente);
    }

    public void eliminar(Cliente cliente) {
        crud.deleteById(cliente.getCedula());
    }
}
