package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.BadRequestException;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Dao.IUsuarioDao;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public GetUsuarioDto findById(Long id) {
        var usuario = usuarioDao.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con id: " + id + " no existe"));
        return new GetUsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getCreatedAt());
    }

    @Override
    public List<GetUsuarioDto> findAll() {
        return usuarioDao.findAll().stream().map(usuario -> new GetUsuarioDto(usuario.getId(),
                usuario.getUsername(), usuario.getCreatedAt())).collect(Collectors.toList());
    }


    private void validarDatos(UsuarioDto usuarioDto){
        if(usuarioDao.existsByEmail(usuarioDto.getEmail())){
            throw new BadRequestException("El email " + usuarioDto.getEmail() + " ya se encuentra registrado");
        }
    }








}
