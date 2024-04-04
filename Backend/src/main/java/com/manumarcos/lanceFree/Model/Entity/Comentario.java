package com.manumarcos.lanceFree.Model.Entity;

import com.manumarcos.lanceFree.Model.Enums.EstadoComentario;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "comentario")
public class Comentario {

    @EmbeddedId
    private ComentarioKey id;
    private Date fecha;
    private String mensaje;
    private EstadoComentario estado;
    private int puntaje;
    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public Comentario(ComentarioKey id, Date fecha, String mensaje, EstadoComentario estado, int puntaje, Cliente cliente, Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.estado = estado;
        this.puntaje = puntaje;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Comentario() {

    }

    public ComentarioKey getId() {
        return id;
    }

    public void setId(ComentarioKey id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public EstadoComentario getEstado() {
        return estado;
    }

    public void setEstado(EstadoComentario estado) {
        this.estado = estado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
