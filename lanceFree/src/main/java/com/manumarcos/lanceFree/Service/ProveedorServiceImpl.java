package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IProveedorDao;
import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Service.Dto.ProveedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    public List<ProveedorDto> findAll() {
        List<Proveedor> proveedores = proveedorDao.findAll();
        List<ProveedorDto> proveedorDtos = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            proveedorDtos.add(new ProveedorDto(proveedor));
        }
        return proveedorDtos;
    }

    @Override
    public ProveedorDto findById(Long id) {
        Proveedor proveedor = proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con el id %d no existe", id)));
        return new ProveedorDto(proveedor);
    }

    @Override
    public ProveedorDto save(ProveedorDto proveedorDto) {
        Proveedor proveedor = new Proveedor(proveedorDto.getNombre(), proveedorDto.getApellido(), proveedorDto.getEmail(),
                proveedorDto.getTelefono(), proveedorDto.getTitulo());
        return new ProveedorDto(proveedorDao.save(proveedor));
    }

    @Override
    public ProveedorDto update(Long id, ProveedorDto proveedorDto) {
        Proveedor proveedorToUpdate = this.getProveedor(id);

        proveedorToUpdate.setTitulo(proveedorDto.getTitulo());
        proveedorToUpdate.setEmail(proveedorDto.getEmail());
        proveedorToUpdate.setNombre(proveedorDto.getNombre());
        proveedorToUpdate.setApellido(proveedorDto.getApellido());
        proveedorToUpdate.setTelefono(proveedorDto.getTelefono());

        return new ProveedorDto(proveedorDao.update(proveedorToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        Proveedor proveedorToDelete = this.getProveedor(id);
        if(proveedorToDelete != null){
            proveedorDao.deleteById(proveedorToDelete.getId());
        }
    }

    private Proveedor getProveedor(Long id) {
        return proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con el id %d no existe", id)));
    }

}
