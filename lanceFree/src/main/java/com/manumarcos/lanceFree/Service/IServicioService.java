package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Servicio;

import java.util.List;

public interface IServicioService {

    List<Servicio> findAll();
    Servicio findById(Long id);
    Servicio save(Servicio servicio);
    Servicio update(Long id, Servicio servicio);
    void deleteById(Long id);


}
