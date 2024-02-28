package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Servicio;

public class ServicioDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private float duracion;
    private float precio;
    private String frecuencia;
    private Long proveedorId;
    private Long categoriaId;

    public ServicioDto(Long id, String nombre, String descripcion, float duracion, float precio, String frecuencia, Long proveedorId, Long categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.frecuencia = frecuencia;
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
    }

    public ServicioDto(Servicio servicio){
        this.id = servicio.getId();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
        this.duracion = servicio.getDuracion();
        this.precio = servicio.getPrecio();
        this.frecuencia = servicio.getFrecuencia().toString();
        this.proveedorId = servicio.getProveedor().getId();
        this.categoriaId = servicio.getCategoria().getId();
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

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }


}
