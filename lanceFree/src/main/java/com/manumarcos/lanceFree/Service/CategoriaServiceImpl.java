package com.manumarcos.lanceFree.Service;

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
        return null;
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria update(Categoria categoria) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
