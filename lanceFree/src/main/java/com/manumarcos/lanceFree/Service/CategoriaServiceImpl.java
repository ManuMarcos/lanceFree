package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.ICategoriaDao;
import com.manumarcos.lanceFree.Model.Entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDao categoriaDao;


    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La categoria con id: %d no existe", id)));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        Categoria categoriaToUpdate = findById(id);

        categoriaToUpdate.setNombre(categoria.getNombre());

        return categoriaDao.update(categoria);
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
