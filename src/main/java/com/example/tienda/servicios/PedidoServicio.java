package com.example.tienda.servicios;

import com.example.tienda.controladores.PedidoControlador;
import com.example.tienda.controladores.ProductoControlador;
import com.example.tienda.modelos.Pedido;
import com.example.tienda.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Pedido")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PedidoServicio {

    @Autowired
    private PedidoControlador controlador;

    @GetMapping("/all")
    public List<Pedido> obtenerTodos() {
        return controlador.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPorId(@PathVariable("id") int orden) {
        return controlador.obtenerId(orden);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido guardar(@RequestBody Pedido pedido) {
        return controlador.guardar(pedido);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido actualizar(@RequestBody Pedido pedido) {
        return controlador.actualizar(pedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") int orden) {
        return controlador.eliminar(orden);
    }
}
