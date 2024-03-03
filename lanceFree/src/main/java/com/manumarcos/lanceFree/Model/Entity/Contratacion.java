package com.manumarcos.lanceFree.Model.Entity;

import com.manumarcos.lanceFree.Model.Enums.EstadoContratacion;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity(name = "contratacion")
public class Contratacion {
    @EmbeddedId
    private ContratacionKey id;
    @Enumerated(EnumType.STRING)
    private EstadoContratacion estado;
    private String motivo;
    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public Contratacion(ContratacionKey id, EstadoContratacion estado, String motivo, Cliente cliente, Servicio servicio) {
        this.id = id;
        this.estado = estado;
        this.motivo = motivo;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Contratacion(EstadoContratacion estado, String motivo, @NotNull Cliente cliente, @NotNull Servicio servicio) {
        this.id = new ContratacionKey(cliente.getId(), servicio.getId());
        this.estado = estado;
        this.motivo = motivo;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Contratacion() {

    }

    public ContratacionKey getId() {
        return id;
    }

    public void setId(ContratacionKey id) {
        this.id = id;
    }

    public EstadoContratacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoContratacion estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

