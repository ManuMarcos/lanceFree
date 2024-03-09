package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.DuplicateException;
import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.Dto.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public ClienteDto save(SignUpRequestDto signUpRequestDto) {
        String email = signUpRequestDto.email();
        Optional<Cliente> existeCliente = clienteDao.findByEmail(email);
        if(existeCliente.isPresent()){
            throw new DuplicateException(String.format("Ya existe un usuario con el email %s", email));
        }
        String hashedPassword = passwordEncoder.encode(signUpRequestDto.password());
        Cliente cliente = new Cliente(signUpRequestDto.nombre(),signUpRequestDto.apellido(),
                signUpRequestDto.email(), null, hashedPassword, null);
        return new ClienteDto(clienteDao.save(cliente));
    }

    private Cliente findByEmail(String email){
        return clienteDao.findByEmail(email).orElseThrow(() -> new ItemNotFoundException("El cliente con email:" +  email + " no existe"));
    }

}
