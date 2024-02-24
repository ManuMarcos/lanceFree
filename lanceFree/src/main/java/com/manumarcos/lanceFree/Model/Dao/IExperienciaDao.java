package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Experiencia;

import java.util.List;
import java.util.Optional;

public interface IExperienciaDao {

    List<Experiencia> findAll();
    Optional<Experiencia> findById(Long id);
    Experiencia save(Experiencia experiencia);
    Experiencia update(Experiencia experiencia);
    void deleteById(Long id);



}
