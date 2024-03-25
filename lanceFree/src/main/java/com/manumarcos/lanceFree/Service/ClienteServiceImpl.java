package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.BadRequestException;
import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Dao.IUsuarioDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IUsuarioDao usuarioDao;
    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClienteDto> findAll() {
        List<Cliente> clientes = clienteDao.findAll();
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for(Cliente cliente : clientes){
            clienteDtos.add(modelMapper.map(cliente, ClienteDto.class));

        }
        return clienteDtos;
    }

    @Override
    public ClienteDto findById(Long id) {
        Cliente cliente = clienteDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El cliente con id %d no existe",id)));
        return modelMapper.map(cliente, ClienteDto.class);
    }

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        this.validarDatos(clienteDto);
        var usuario = modelMapper.map(clienteDto.getUsuario(), Usuario.class);
        usuario.setRoles(Set.of(roleDao.findRoleByRoleAuthority("CLIENTE")));
        usuario.setContrasena(passwordEncoder.encode(usuario.getPassword()));
        Usuario usuarioCreado = usuarioDao.save(usuario);

        var cliente = new Cliente(usuarioCreado, clienteDto.getHorarioContacto());
        var clienteCreado = clienteDao.save(cliente);
        return modelMapper.map(clienteCreado, ClienteDto.class);
    }



    /*
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
    */

    @Override
    public void deleteById(Long id) {
        Optional<Cliente> clienteToDelete = clienteDao.findById(id);
        if(clienteToDelete.isPresent()) {
            //clienteDao.deleteById(id);
            usuarioDao.deleteById(clienteToDelete.get().getUsuario().getId());
        }
        else{
            throw new ItemNotFoundException(String.format("El cliente con id %d no existe",id));
        }
    }




    private void validarDatos(ClienteDto clienteDto){
        if(usuarioDao.existsByEmail(clienteDto.getUsuario().getEmail())){
            throw new BadRequestException("El email " + clienteDto.getUsuario().getEmail() + " ya se encuentra registrado");
        }
    }



    private Cliente findByEmail(String email){
        return clienteDao.findByEmail(email).orElseThrow(() -> new ItemNotFoundException("El cliente con email:" +  email + " no existe"));
    }

}
