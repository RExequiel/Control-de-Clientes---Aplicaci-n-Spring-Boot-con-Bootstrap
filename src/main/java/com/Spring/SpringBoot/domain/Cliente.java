package com.Spring.SpringBoot.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Double saldo;
}
