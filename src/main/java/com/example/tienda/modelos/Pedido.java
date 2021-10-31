package com.example.tienda.modelos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Data
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orden;
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToMany(mappedBy = "pedidos")
    private Set<Producto> productos;
    private Double total;

}
