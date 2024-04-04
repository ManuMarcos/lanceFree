package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.ICategoriaDao;
import com.manumarcos.lanceFree.Model.Dao.IProveedorDao;
import com.manumarcos.lanceFree.Model.Dao.IServicioDao;
import com.manumarcos.lanceFree.Model.Entity.Categoria;
import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Model.Entity.Servicio;
import com.manumarcos.lanceFree.Model.Enums.Frecuencia;
import com.manumarcos.lanceFree.Service.Dto.ServicioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService{

    @Autowired
    private IServicioDao servicioDao;

    @Autowired
    private ICategoriaDao categoriaDao;

    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    public List<ServicioDto> findAll() {
        List<Servicio> servicios = servicioDao.findAll();
        List<ServicioDto> servicioDtos = new ArrayList<>();
        for (Servicio servicio : servicios){
            servicioDtos.add(new ServicioDto(servicio));
        }
        return servicioDtos;
    }

    @Override
    public ServicioDto findById(Long id) {
        Servicio servicio = this.getServicio(id);
        return new ServicioDto(servicio);
    }

    @Override
    public ServicioDto save(ServicioDto servicioDto) {
        Proveedor proveedor = this.getProveedor(servicioDto.getProveedorId());
        Categoria categoria = this.getCategoria(servicioDto.getCategoriaId());
        Servicio servicio = new Servicio(servicioDto.getNombre(), servicioDto.getDescripcion(),
                servicioDto.getDuracion(), servicioDto.getPrecio(), Frecuencia.findByName(servicioDto.getFrecuencia()), proveedor, categoria);
        return new ServicioDto(servicioDao.save(servicio));
    }

    @Override
    public ServicioDto update(Long id, ServicioDto servicioDto) {
        Servicio servicioToUpdate = this.getServicio(id);

        servicioToUpdate.setDescripcion(servicioDto.getDescripcion());
        servicioToUpdate.setDuracion(servicioDto.getDuracion());
        servicioToUpdate.setNombre(servicioDto.getNombre());
        servicioToUpdate.setFrecuencia(Frecuencia.findByName(servicioDto.getFrecuencia()));
        servicioToUpdate.setPrecio(servicioDto.getPrecio());

        return new ServicioDto(servicioDao.update(servicioToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        Servicio servicio = this.getServicio(id);
        if(servicio != null){
            servicioDao.deleteById(id);
        }
    }

    private Servicio getServicio(Long id){
        return servicioDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El servicio con id %d no existe", id)));
    }

    private Categoria getCategoria(Long id){
        return categoriaDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La categoria con id %d no existe", id)));
    }

    private Proveedor getProveedor(Long id){
        return proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con id %d no existe", id)));
    }

}
