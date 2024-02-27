package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El cliente con id %d no existe",id)));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteToUpdate = this.findById(id);

        clienteToUpdate.setHorarioContacto(cliente.getHorarioContacto());
        clienteToUpdate.setContrataciones(cliente.getContrataciones());
        clienteToUpdate.setComentarios(cliente.getComentarios());

        return clienteDao.update(clienteToUpdate);
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
