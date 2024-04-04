package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Servicio;

import java.util.List;
import java.util.Optional;

public interface IServicioDao {

    List<Servicio> findAll();
    Optional<Servicio> findById(Long id);
    Servicio save(Servicio servicio);
    Servicio update(Servicio servicio);
    void deleteById(Long id);

}
