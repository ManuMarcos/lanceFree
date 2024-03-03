package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Contratacion;

public class ContratacionDto {

    private Long clienteId;
    private Long servicioId;
    private String estado;
    private String motivo;

    public ContratacionDto(Long clienteId, Long servicioId, String estado, String motivo) {
        this.clienteId = clienteId;
        this.servicioId = servicioId;
        this.estado = estado;
        this.motivo = motivo;
    }

    public ContratacionDto(Contratacion contratacion){
        this.clienteId = contratacion.getCliente().getId();
        this.servicioId = contratacion.getServicio().getId();
        this.estado = contratacion.getEstado().toString();
        this.motivo = contratacion.getMotivo();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
