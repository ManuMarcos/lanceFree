package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;

import java.util.List;

public interface IProveedorService {

    List<Proveedor> findAll();
    Proveedor findById(Long id);
    Proveedor save(Proveedor proveedor);
    Proveedor update(Long id, Proveedor proveedor);
    void deleteById(Long id);
}
