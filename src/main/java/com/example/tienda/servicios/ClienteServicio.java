package com.example.tienda.servicios;

import com.example.tienda.controladores.ClienteControlador;
import com.example.tienda.modelos.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cliente")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteServicio {

    @Autowired
    private ClienteControlador controlador;

    @GetMapping("/all")
    public List<Cliente> obtenerTodos() {
        return controlador.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerPorId(@PathVariable("id") long cedula) {
        return controlador.obtenerId(cedula);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardar(@RequestBody Cliente cliente) {
        return controlador.guardar(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizar(@RequestBody Cliente cliente) {
        return controlador.actualizar(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") long cedula) {
        return controlador.eliminar(cedula);
    }
}
