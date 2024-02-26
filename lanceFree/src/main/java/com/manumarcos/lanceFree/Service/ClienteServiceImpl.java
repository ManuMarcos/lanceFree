package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<ClienteDto> findAll() {
        List<Cliente> clientes = clienteDao.findAll();
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for(Cliente cliente : clientes){
            clienteDtos.add(new ClienteDto(cliente));
        }
        return clienteDtos;
    }

    @Override
    public ClienteDto findById(Long id) {
        Cliente cliente = clienteDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El cliente con id %d no existe",id)));
        return new ClienteDto(cliente);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        Cliente cliente = new Cliente(clienteDto.getId(), clienteDto.getNombre(), clienteDto.getApellido(),
                clienteDto.getEmail(), clienteDto.getTelefono(), clienteDto.getHorarioContacto());
        return new ClienteDto(clienteDao.save(cliente));
    }

    @Override
    public ClienteDto update(Long id, ClienteDto clienteDto) {
        try{
            Cliente clienteToUpdate = clienteDao.findById(id).get();
            clienteToUpdate.setHorarioContacto(clienteDto.getHorarioContacto());
            clienteToUpdate.setApellido(clienteDto.getApellido());
            clienteToUpdate.setEmail(clienteDto.getEmail());
            clienteToUpdate.setTelefono(clienteDto.getTelefono());
            clienteToUpdate.setNombre(clienteDto.getNombre());
            return new ClienteDto(clienteDao.update(clienteToUpdate));
        }
        catch(Exception e){
            throw new ItemNotFoundException(String.format("El cliente con id %d no existe", id));
        }
    }

    @Override
    public void deleteById(Long id) {
        if(clienteDao.findById(id).isPresent()) {
            clienteDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("El cliente con id %d no existe",id));
        }
    }
}
