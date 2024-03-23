package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.BadRequestException;
import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IProveedorDao;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Dao.IUsuarioDao;
import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.ProveedorDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<ProveedorDto> findAll() {
        List<Proveedor> proveedores = proveedorDao.findAll();
        List<ProveedorDto> proveedorDtos = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            proveedorDtos.add(modelMapper.map(proveedor, ProveedorDto.class));
        }
        return proveedorDtos;
    }

    @Override
    public ProveedorDto findById(Long id) {
        Proveedor proveedor = proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con el id %d no existe", id)));
        return modelMapper.map(proveedor, ProveedorDto.class);
    }

    @Override
    public ProveedorDto save(ProveedorDto proveedorDto) {
        this.validarDatos(proveedorDto);
        var usuario = modelMapper.map(proveedorDto.getUsuario(), Usuario.class);
        usuario.setRoles(Set.of(roleDao.findRoleByRoleAuthority("PROVEEDOR")));
        usuario.setContrasena(passwordEncoder.encode(usuario.getPassword()));
        var usuarioCreado = usuarioDao.save(usuario);

        Proveedor proveedor = new Proveedor(proveedorDto.getTitulo(), usuarioCreado);
        var proveedorCreado = proveedorDao.save(proveedor);

        return modelMapper.map(proveedorCreado, ProveedorDto.class);
    }


    /*
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
    */

    @Override
    public void deleteById(Long id) {
        Proveedor proveedorToDelete = this.getProveedor(id);
        if(proveedorToDelete != null){
            //proveedorDao.deleteById(proveedorToDelete.getId());
        }
    }

    private Proveedor getProveedor(Long id) {
        return proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con el id %d no existe", id)));
    }

    private void validarDatos(ProveedorDto proveedorDto){
        if(usuarioDao.existsByEmail(proveedorDto.getUsuario().getEmail())){
            throw new BadRequestException("El email " + proveedorDto.getUsuario().getEmail() +
                    " ya se encuentra registrado");
        }
    }

}
