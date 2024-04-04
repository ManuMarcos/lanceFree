package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "proveedor")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Proveedor extends PerfilUsuario{
    private String titulo;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios;

    public Proveedor(String titulo, Usuario usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }
}
