package com.example.tienda.controladores;

import com.example.tienda.modelos.Pedido;
import com.example.tienda.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PedidoControlador {

    @Autowired
    private PedidoRepositorio repositorio;

    public List<Pedido> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Pedido> obtenerId(int id) {
        return repositorio.obtenerId(id);
    }

    public Pedido guardar(Pedido pedido) {
        if (pedido.getOrden() == null) {
            pedido.setFechaPedido(new Date());
            AtomicReference<Double> suma = new AtomicReference<>((double) 0);
            pedido.getProductos().forEach(producto -> {
                suma.updateAndGet(v -> new Double((double) (v + producto.getPrecio())));
            });
            pedido.setTotal(suma.get());
            return repositorio.guardarActualizar(pedido);
        } else {
            Optional<Pedido> p = repositorio.obtenerId(pedido.getOrden());
            if (p.isEmpty()) {
                return repositorio.guardarActualizar(pedido);
            } else {
                return pedido;
            }
        }
    }

    public Pedido actualizar(Pedido pedido) {
        if (pedido.getOrden() != null) {
            Optional<Pedido> p = repositorio.obtenerId(pedido.getOrden());
            if (!p.isEmpty()) {
                return repositorio.guardarActualizar(pedido);
            } else {
                return pedido;
            }
        } else {
            return pedido;
        }
    }

    public boolean eliminar(int codigo) {
        return obtenerId(codigo).map(producto -> {
            repositorio.eliminar(producto);
            return true;
        }).orElse(false);
    }
}
