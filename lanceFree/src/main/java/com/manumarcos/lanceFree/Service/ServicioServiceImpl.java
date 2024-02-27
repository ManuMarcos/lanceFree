package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IServicioDao;
import com.manumarcos.lanceFree.Model.Entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService{

    @Autowired
    private IServicioDao servicioDao;


    @Override
    public List<Servicio> findAll() {
        return servicioDao.findAll();
    }

    @Override
    public Servicio findById(Long id) {
        return servicioDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El servicio con id %d no existe", id)));
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioDao.save(servicio);
    }

    @Override
    public Servicio update(Long id, Servicio servicio) {
        Servicio servicioToUpdate = this.findById(id);

        servicioToUpdate.setCategoria(servicio.getCategoria());
        servicioToUpdate.setDescripcion(servicio.getDescripcion());
        servicioToUpdate.setDuracion(servicio.getDuracion());
        servicioToUpdate.setNombre(servicio.getNombre());
        servicioToUpdate.setFrecuencia(servicio.getFrecuencia());
        servicioToUpdate.setPrecio(servicio.getPrecio());
        servicioToUpdate.setProveedor(servicio.getProveedor());
        servicioToUpdate.setComentarios(servicio.getComentarios());
        servicioToUpdate.setContrataciones(servicio.getContrataciones());

        return servicioDao.update(servicioToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(servicioDao.findById(id).isPresent()){
            servicioDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("El servicio con id %d no existe", id));
        }
    }
}
