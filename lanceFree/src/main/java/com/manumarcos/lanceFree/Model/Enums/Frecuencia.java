package com.manumarcos.lanceFree.Model.Enums;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;

public enum Frecuencia {
    UNICA,SEMANAL,GRUPAL;


    public static Frecuencia findByName(String name){
        Frecuencia result = null;
        for(Frecuencia frecuencia : values()){
            if(frecuencia.name().equalsIgnoreCase(name)){
                result = frecuencia;
                break;
            }
        }
        if(result == null){
            String mensaje = "La frecuencia con valor: " + name + " no existe";
            throw new ItemNotFoundException(mensaje);
        }
        return result;
    }

}
