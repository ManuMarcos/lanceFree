package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "proveedor")
public class Proveedor extends Usuario{
    private String titulo;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios;

    public Proveedor(Long id, String nombre, String apellido, String email, String telefono, String contrasena, String titulo, List<Experiencia> experiencias, List<Servicio> servicios) {
        super(id, nombre, apellido, email, telefono, contrasena);
        this.titulo = titulo;
        this.experiencias = experiencias;
        this.servicios = servicios;
    }

    public Proveedor(String nombre, String apellido, String email, String telefono, String titulo) {
        super(nombre, apellido, email, telefono);
        this.titulo = titulo;
    }

    public Proveedor() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
