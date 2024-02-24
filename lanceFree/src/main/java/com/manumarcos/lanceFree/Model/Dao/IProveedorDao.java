package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorDao {

    List<Proveedor> findAll();
    Optional<Proveedor> findById(Long id);
    Proveedor save(Proveedor proveedor);
    Proveedor update(Proveedor proveedor);
    void deleteById(Long id);



}
