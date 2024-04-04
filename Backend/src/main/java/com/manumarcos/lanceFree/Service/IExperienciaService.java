package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Experiencia;
import com.manumarcos.lanceFree.Service.Dto.ExperienciaDto;

import java.util.List;

public interface IExperienciaService {

    List<ExperienciaDto> findAll();
    ExperienciaDto findById(Long id);
    ExperienciaDto save(ExperienciaDto experienciaDto);
    ExperienciaDto update(Long id, ExperienciaDto experienciaDto);
    void deleteById(Long id);
}
