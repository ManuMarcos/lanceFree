package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Contratacion;

import java.util.List;
import java.util.Optional;

public interface IContratacionDao {

    List<Contratacion> findAll();
    Optional<Contratacion> findById(Long id);
    Contratacion save(Contratacion contratacion);
    Contratacion update(Contratacion contratacion);
    void deleteById(Long id);



}
