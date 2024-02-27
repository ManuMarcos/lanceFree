package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IContratacionDao;
import com.manumarcos.lanceFree.Model.Entity.Contratacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratacionServiceImpl implements IContratacionService{

    @Autowired
    private IContratacionDao contratacionDao;

    @Override
    public List<Contratacion> findAll() {
        return contratacionDao.findAll();
    }

    @Override
    public Contratacion findById(Long id) {
        return contratacionDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La contratacion con id %d no existe", id)));
    }

    @Override
    public Contratacion save(Contratacion contratacion) {
        return contratacionDao.save(contratacion);
    }

    @Override
    public Contratacion update(Long id, Contratacion contratacion) {
        Contratacion contratacionToUpdate = this.findById(id);

        contratacionToUpdate.setCliente(contratacion.getCliente());
        contratacionToUpdate.setEstado(contratacion.getEstado());
        contratacionToUpdate.setMotivo(contratacion.getMotivo());
        contratacionToUpdate.setServicio(contratacion.getServicio());

        return contratacionDao.update(contratacionToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(contratacionDao.findById(id).isPresent()){
            contratacionDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("La contratacion con id %d no existe", id));
        }
    }
}
