package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Model.Entity.Usuario;

public class ProveedorDto extends UsuarioDto{

    private String titulo;

    public ProveedorDto(Long id, String nombre, String apellido, String email, String telefono, String titulo) {
        super(id, nombre, apellido, email, telefono);
        this.titulo = titulo;
    }

    public ProveedorDto(Proveedor proveedor) {
        super(proveedor);
        this.titulo = proveedor.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
