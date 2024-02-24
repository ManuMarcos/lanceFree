package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "proveedor")
public class Proveedor extends Usuario{
    private String titulo;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios;


}
