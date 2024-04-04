package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Categoria;
import com.manumarcos.lanceFree.Service.Dto.CategoriaDto;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<CategoriaDto> findAll();
    CategoriaDto findById(Long id);
    CategoriaDto save(CategoriaDto categoriaDto);
    CategoriaDto update(Long id, CategoriaDto categoriaDto);
    void deleteById(Long id);


}
