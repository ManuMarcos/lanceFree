package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    private Date fechaDesde;
    private Date fechaHasta;
    private String descripcion;

}
