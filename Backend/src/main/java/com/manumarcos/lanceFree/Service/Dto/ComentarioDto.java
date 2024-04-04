package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Comentario;
import com.manumarcos.lanceFree.Model.Enums.EstadoComentario;

import java.util.Date;

public class ComentarioDto {

    private Long clienteId;
    private Long servicioId;
    private Date fecha;
    private String mensaje;
    private EstadoComentario estado;
    private int puntaje;

    public ComentarioDto(Long clienteId, Long servicioId, Date fecha, String mensaje, EstadoComentario estado, int puntaje) {
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.estado = estado;
        this.puntaje = puntaje;
    }

    public ComentarioDto(Comentario comentario){
        this.clienteId = comentario.getCliente().getId();
        this.servicioId = comentario.getServicio().getId();
        this.fecha = comentario.getFecha();
        this.mensaje = comentario.getMensaje();
        this.estado = comentario.getEstado();
        this.puntaje = comentario.getPuntaje();
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getServicioId() {
        return servicioId;
    }

    public void setServicioId(Long servicioId) {
        this.servicioId = servicioId;
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
}
