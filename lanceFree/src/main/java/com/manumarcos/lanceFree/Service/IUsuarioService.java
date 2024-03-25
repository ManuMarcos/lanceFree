package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;

import java.util.List;


public interface IUsuarioService {

    //UsuarioDto save(UsuarioDto usuarioDto);

    Usuario findByEmail(String email);

    UsuarioDto crearAdmin(UsuarioDto usuarioDto);
    GetUsuarioDto findById(Long id);
    List<GetUsuarioDto> findAll();
}
