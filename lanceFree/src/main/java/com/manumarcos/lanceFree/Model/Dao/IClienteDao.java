package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDao {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void deleteById(Long id);

}
