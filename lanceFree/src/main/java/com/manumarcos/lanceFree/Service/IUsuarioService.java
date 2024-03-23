package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;

import java.util.List;


public interface IUsuarioService {

    GetUsuarioDto findById(Long id);

    List<GetUsuarioDto> findAll();
}
