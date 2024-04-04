package com.manumarcos.lanceFree.Model.Enums;

import com.manumarcos.lanceFree.Exception.Exceptions.InvalidValueException;

public enum EstadoContratacion {
    SOLICITADA,ACEPTADA,FINALIZADA,CANCELADA;

    public static EstadoContratacion findByName(String name){
        for(EstadoContratacion estadoContratacion : EstadoContratacion.values()){
            if(estadoContratacion.name().equalsIgnoreCase(name)){
                return estadoContratacion;
            }
        }
        String mensaje = "El estado de contratacion con valor: " + name + " no existe";
        throw new InvalidValueException(mensaje);
    }
}
