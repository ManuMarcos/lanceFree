package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ContratacionKey implements Serializable{

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "servicio_id")
    private Long servicioId;
}
