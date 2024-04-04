package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Service.Dto.ProveedorDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;

import java.util.List;

public interface IProveedorService {

    List<ProveedorDto> findAll();
    ProveedorDto findById(Long id);
    ProveedorDto save(ProveedorDto proveedorDto);
    //ProveedorDto update(Long id, ProveedorDto proveedorDto);

    void deleteById(Long id);
}
