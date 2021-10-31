package com.example.tienda.modelos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "producto")
@Data
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Double cantidad;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "pedido_producto",
            joinColumns = {@JoinColumn(name = "codigo")},
            inverseJoinColumns = {@JoinColumn(name = "orden")}
    )
    private Set<Pedido> pedidos;

}
