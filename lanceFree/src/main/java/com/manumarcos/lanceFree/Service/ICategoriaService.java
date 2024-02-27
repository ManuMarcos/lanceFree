package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<Categoria> findAll();
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void deleteById(Long id);




}
