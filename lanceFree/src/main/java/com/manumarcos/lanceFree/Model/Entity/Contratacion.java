package com.manumarcos.lanceFree.Model.Entity;

import com.manumarcos.lanceFree.Model.Enums.EstadoContratacion;
import jakarta.persistence.*;

@Entity(name = "contratacion")
public class Contratacion {
    @EmbeddedId
    private ContratacionKey id;
    private EstadoContratacion estado;
    private String motivo;
    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;


}
