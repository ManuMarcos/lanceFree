package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Servicio;
import com.manumarcos.lanceFree.Service.Dto.ServicioDto;

import java.util.List;

public interface IServicioService {

    List<ServicioDto> findAll();
    ServicioDto findById(Long id);
    ServicioDto save(ServicioDto servicioDto);
    ServicioDto update(Long id, ServicioDto servicioDto);
    void deleteById(Long id);


}
