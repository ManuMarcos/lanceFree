package com.manumarcos.lanceFree.Service.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manumarcos.lanceFree.Model.Entity.Experiencia;

import java.util.Date;

public class ExperienciaDto {

    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaDesde;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaHasta;
    private String descripcion;
    private Long proveedorId;

    public ExperienciaDto(Long id, Date fechaDesde, Date fechaHasta, String descripcion, Long proveedorId) {
        this.id = id;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.descripcion = descripcion;
        this.proveedorId = proveedorId;
    }

    public ExperienciaDto(Experiencia experiencia){
        this.id = experiencia.getId();
        this.fechaDesde = experiencia.getFechaDesde();
        this.fechaHasta = experiencia.getFechaHasta();
        this.descripcion = experiencia.getDescripcion();
        this.proveedorId = experiencia.getProveedor().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }
}
