package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Categoria;

public class CategoriaDto {

    private Long id;
    private String nombre;

    public CategoriaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaDto(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public CategoriaDto(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDto(Categoria categoria){
        this.nombre = categoria.getNombre();
        this.id = categoria.getId();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
