package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.ICategoriaDao;
import com.manumarcos.lanceFree.Model.Entity.Categoria;
import com.manumarcos.lanceFree.Service.Dto.CategoriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDao categoriaDao;


    @Override
    public List<CategoriaDto> findAll() {
        List<Categoria> categorias = categoriaDao.findAll();
        List<CategoriaDto> categoriaDtos = new ArrayList<>();
        for(Categoria categoria : categorias){
            categoriaDtos.add(new CategoriaDto(categoria));
        }
        return categoriaDtos;
    }

    @Override
    public CategoriaDto findById(Long id) {
        Categoria categoria = categoriaDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La categoria con id: %d no existe", id)));
        return new CategoriaDto(categoria);
    }

    @Override
    public CategoriaDto save(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria(categoriaDto.getNombre());
        return new CategoriaDto(categoriaDao.save(categoria));
    }

    @Override
    public CategoriaDto update(Long id, CategoriaDto categoriaDto) {
        try{
            Categoria categoriaToUpdate = categoriaDao.findById(id).get();
            categoriaToUpdate.setNombre(categoriaDto.getNombre());
            return new CategoriaDto(categoriaDao.update(categoriaToUpdate));
        }
        catch(Exception e){
            throw new ItemNotFoundException(String.format("La categoria con id %d no existe", id));
        }
    }

    @Override
    public void deleteById(Long id) {
        if(categoriaDao.findById(id).isPresent()){
            categoriaDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("La categoria con id: %d no existe", id));
        }
    }


}
