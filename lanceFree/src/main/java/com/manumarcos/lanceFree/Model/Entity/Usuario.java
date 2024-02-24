package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String email;
    private String telefono;
    private String contrasena;


}
