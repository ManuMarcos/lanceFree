package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Contratacion;
import com.manumarcos.lanceFree.Service.Dto.ContratacionDto;

import java.util.List;

public interface IContratacionService {

    List<ContratacionDto> findAll();
    ContratacionDto findById(Long clienteId, Long servicioId);
    ContratacionDto save(ContratacionDto contratacionDto);
    ContratacionDto update(Long clienteId, Long servicioId, ContratacionDto contratacionDto);
    void deleteById(Long clienteId, Long servicioId);
}
