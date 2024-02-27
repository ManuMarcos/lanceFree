package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Experiencia;

import java.util.List;

public interface IExperienciaService {

    List<Experiencia> findAll();
    Experiencia findById(Long id);
    Experiencia save(Experiencia experiencia);
    Experiencia update(Long id, Experiencia experiencia);
    void deleteById(Long id);
}
