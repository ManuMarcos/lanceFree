package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "cliente")
public class Cliente extends Usuario{

    private String horarioContacto;

    @OneToMany(mappedBy = "cliente")
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;


}
