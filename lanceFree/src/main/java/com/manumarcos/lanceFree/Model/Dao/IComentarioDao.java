package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Comentario;

import java.util.List;
import java.util.Optional;

public interface IComentarioDao {

    List<Comentario> findAll();
    Optional<Comentario> findById(Long id);
    Comentario save(Comentario comentario);
    Comentario update(Comentario comentario);
    void deleteById(Long id);




}
