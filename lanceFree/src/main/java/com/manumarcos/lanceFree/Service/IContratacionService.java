package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Contratacion;

import java.util.List;

public interface IContratacionService {

    List<Contratacion> findAll();
    Contratacion findById(Long id);
    Contratacion save(Contratacion contratacion);
    Contratacion update(Long id, Contratacion contratacion);
    void deleteById(Long id);
}
