package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Model.Entity.Comentario;

import java.util.List;

public interface IComentarioService {

    List<Comentario> findAll();
    Comentario findById(Long id);
    Comentario save(Comentario comentario);
    Comentario update(Long id, Comentario comentario);
    void deleteById(Long id);
}
