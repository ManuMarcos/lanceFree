package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;

import java.util.List;

public interface IClienteService {

    List<ClienteDto> findAll();
    ClienteDto findById(Long id);
    ClienteDto save(ClienteDto clienteDto);
    ClienteDto update(Long id,ClienteDto clienteDto);
    void deleteById(Long id);

}
