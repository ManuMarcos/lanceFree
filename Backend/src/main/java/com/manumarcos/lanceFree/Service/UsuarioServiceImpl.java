package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.BadRequestException;
import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Dao.IUsuarioDao;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.RoleDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Usuario findByEmail(String email) {
        return usuarioDao.findUsuarioByEmail(email).orElseThrow(() ->
                new ItemNotFoundException("El usuario no existe"));
    }

    @Override
    public UsuarioDto crearAdmin(UsuarioDto usuarioDto) {
        if(usuarioDao.existsByEmail(usuarioDto.getEmail())){
            throw new BadRequestException("Ya existe un usuario con el mail " + usuarioDto.getEmail());
        }
        var usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setRoles(Set.of(roleDao.findRoleByRoleAuthority("ADMINISTRADOR")));
        usuario.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        return modelMapper.map(usuarioDao.save(usuario), UsuarioDto.class);
    }

    @Override
    public GetUsuarioDto findById(Long id) {
        var usuario = usuarioDao.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con id: " + id + " no existe"));
        return modelMapper.map(usuario, GetUsuarioDto.class);
    }

    @Override
    public List<GetUsuarioDto> findAll() {
        return usuarioDao.findAll().stream().map(usuario -> {
            modelMapper.map(usuario.getRoles(), RoleDto.class);
            return modelMapper.map(usuario, GetUsuarioDto.class);
                }).collect(Collectors.toList());
    }

    @Override
    public List<GetUsuarioDto> findAllByRole(String role) {
        return usuarioDao.findAllByRolesIsIn(Set.of(roleDao.findRoleByRoleAuthority(role))).stream()
                .map(usuario -> {
                    modelMapper.map(usuario.getRoles(), RoleDto.class);
                    return modelMapper.map(usuario, GetUsuarioDto.class);
                }).collect(Collectors.toList());
    }


    private void validarDatos(UsuarioDto usuarioDto){
        if(usuarioDao.existsByEmail(usuarioDto.getEmail())){
            throw new BadRequestException("El email " + usuarioDto.getEmail() + " ya se encuentra registrado");
        }
    }








}
