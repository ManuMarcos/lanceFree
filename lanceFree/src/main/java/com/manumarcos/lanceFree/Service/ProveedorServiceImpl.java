package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IProveedorDao;
import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService{

    @Autowired
    private IProveedorDao proveedorDao;


    @Override
    public List<Proveedor> findAll() {
        return proveedorDao.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con el id %d no existe", id)));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorDao.save(proveedor);
    }

    @Override
    public Proveedor update(Long id, Proveedor proveedor) {
        Proveedor proveedorToUpdate = this.findById(id);

        proveedorToUpdate.setExperiencias(proveedor.getExperiencias());
        proveedorToUpdate.setServicios(proveedor.getServicios());
        proveedorToUpdate.setTitulo(proveedor.getTitulo());
        proveedorToUpdate.setEmail(proveedor.getEmail());
        proveedorToUpdate.setNombre(proveedor.getNombre());
        proveedorToUpdate.setApellido(proveedor.getApellido());
        proveedorToUpdate.setTelefono(proveedor.getTelefono());
        proveedorToUpdate.setContrasena(proveedor.getContrasena());

        return proveedorDao.update(proveedorToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(proveedorDao.findById(id).isPresent()){
            proveedorDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("El proveedor con id %d no existe", id));
        }
    }

}
