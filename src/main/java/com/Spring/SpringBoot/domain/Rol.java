package com.Spring.SpringBoot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    @NotEmpty
    private String nombre;
}
