package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findUsuarioByEmail(String email);
    boolean existsByEmail(String email);
}
