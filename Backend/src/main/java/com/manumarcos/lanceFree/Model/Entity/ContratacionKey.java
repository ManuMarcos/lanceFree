package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ContratacionKey implements Serializable{

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "servicio_id")
    private Long servicioId;

    public ContratacionKey(Long clienteId, Long servicioId) {
        this.clienteId = clienteId;
        this.servicioId = servicioId;
    }

    public ContratacionKey() {

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
}
