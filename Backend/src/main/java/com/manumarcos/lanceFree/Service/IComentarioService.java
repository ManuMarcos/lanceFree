package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Service.Dto.ComentarioDto;

import java.util.List;

public interface IComentarioService {

    List<ComentarioDto> findAll();
    ComentarioDto findById(Long clienteId, Long servicioId);
    ComentarioDto save(ComentarioDto comentarioDto);
    ComentarioDto update(Long clienteId, Long servicioId, ComentarioDto comentarioDto);
    void deleteById(Long clienteId, Long servicioId);
}
