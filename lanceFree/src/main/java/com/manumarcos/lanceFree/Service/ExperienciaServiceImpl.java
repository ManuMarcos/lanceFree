package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IExperienciaDao;
import com.manumarcos.lanceFree.Model.Entity.Experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaServiceImpl implements IExperienciaService{

    @Autowired
    private IExperienciaDao experienciaDao;

    @Override
    public List<Experiencia> findAll() {
        return experienciaDao.findAll();
    }

    @Override
    public Experiencia findById(Long id) {
        return experienciaDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La experiencia con id %d no existe", id)));
    }

    @Override
    public Experiencia save(Experiencia experiencia) {
        return experienciaDao.save(experiencia);
    }

    @Override
    public Experiencia update(Long id, Experiencia experiencia) {
        Experiencia experienciaToUpdate = this.findById(id);

        experienciaToUpdate.setDescripcion(experiencia.getDescripcion());
        experienciaToUpdate.setFechaDesde(experiencia.getFechaDesde());
        experienciaToUpdate.setProveedor(experiencia.getProveedor());
        experienciaToUpdate.setFechaHasta(experiencia.getFechaHasta());

        return experienciaDao.update(experienciaToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(experienciaDao.findById(id).isPresent()){
            experienciaDao.deleteById(id);
        }
        else {
            throw new ItemNotFoundException(String.format("La experiencia con id %d no existe", id));
        }
    }
}
