package com.manumarcos.lanceFree.Model.Entity;

import com.manumarcos.lanceFree.Model.Enums.EstadoComentario;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "comentario")
public class Comentario {

    @EmbeddedId
    private ComentarioKey id;
    private Date fecha;
    private String mensaje;
    private EstadoComentario estado;
    private int puntaje;
    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

}
