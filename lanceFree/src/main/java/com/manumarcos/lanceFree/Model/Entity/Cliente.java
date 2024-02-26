package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "cliente")
public class Cliente extends Usuario{

    private String horarioContacto;

    @OneToMany(mappedBy = "cliente")
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String contrasena, String horarioContacto, List<Contratacion> contrataciones, List<Comentario> comentarios) {
        super(id, nombre, apellido, email, telefono, contrasena);
        this.horarioContacto = horarioContacto;
        this.contrataciones = contrataciones;
        this.comentarios = comentarios;
    }

    public Cliente(Long id, String nombre, String apellido, String email, String telefono, String horarioContacto) {
        super(id, nombre, apellido, email, telefono);
        this.horarioContacto = horarioContacto;
    }

    public Cliente() {
        super();
    }

    public String getHorarioContacto() {
        return horarioContacto;
    }

    public void setHorarioContacto(String horarioContacto) {
        this.horarioContacto = horarioContacto;
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




}
