package com.manumarcos.lanceFree.Model.Entity;

import com.manumarcos.lanceFree.Model.Enums.Frecuencia;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private float duracion;

    private Frecuencia frecuencia;

    @OneToMany(mappedBy = "servicio")
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "servicio")
    private List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Servicio() {
    }

    public Servicio(String nombre, String descripcion, float duracion, Proveedor proveedor, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }
}
