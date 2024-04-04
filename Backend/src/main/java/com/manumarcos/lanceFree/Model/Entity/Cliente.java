package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "cliente")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Cliente extends PerfilUsuario{

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    private String horarioContacto;

    @OneToMany(mappedBy = "cliente")
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    public Cliente(Usuario usuario, String horarioContacto) {
        this.usuario = usuario;
        this.horarioContacto = horarioContacto;
    }


}
