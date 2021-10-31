package com.example.tienda.servicios;

import com.example.tienda.controladores.ProductoControlador;
import com.example.tienda.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Producto")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoServicio {

    @Autowired
    private ProductoControlador controlador;

    @GetMapping("/all")
    public List<Producto> obtenerTodos() {
        return controlador.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerPorId(@PathVariable("id") int codigo) {
        return controlador.obtenerId(codigo);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardar(@RequestBody Producto producto) {
        return controlador.guardar(producto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto actualizar(@RequestBody Producto producto) {
        return controlador.actualizar(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") int codigo) {
        return controlador.eliminar(codigo);
    }
}
