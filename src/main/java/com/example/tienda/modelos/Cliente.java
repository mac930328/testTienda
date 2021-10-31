package com.example.tienda.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()
@Table(name = "cliente")
@Data
public class Cliente implements Serializable {

    @Id
    private Long cedula;
    private String nombre;
    private String apellido;
    private Long celular;
    private String email;
    private String direccion;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    private List<Pedido> pedidos;

}
