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

    private float precio;

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

    public Servicio(Long id, String nombre, String descripcion, float duracion, float precio, Frecuencia frecuencia, List<Contratacion> contrataciones, List<Comentario> comentarios, Proveedor proveedor, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.frecuencia = frecuencia;
        this.contrataciones = contrataciones;
        this.comentarios = comentarios;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }

    public List<Contratacion> getContrataciones() {
        return contrataciones;
    }

    public void setContrataciones(List<Contratacion> contrataciones) {
        this.contrataciones = contrataciones;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
