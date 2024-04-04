package com.manumarcos.lanceFree.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaDesde;

    private Date fechaHasta;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    public Experiencia(Long id, Proveedor proveedor, Date fechaDesde, Date fechaHasta, String descripcion) {
        this.id = id;
        this.proveedor = proveedor;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.descripcion = descripcion;
    }

    public Experiencia(Date fechaDesde, Date fechaHasta, String descripcion, Proveedor proveedor) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public Experiencia() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
}
