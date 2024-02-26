package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioDaoImpl implements IComentarioDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<Comentario> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Comentario> getQuery = currentSession.createQuery("from comentario", Comentario.class);
        return getQuery.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comentario> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Comentario.class, id));
    }

    @Override
    public Comentario save(Comentario comentario) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(comentario);
    }

    @Override
    public Comentario update(Comentario comentario) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(comentario);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Comentario comentarioToDelete = currentSession.get(Comentario.class, id);

        if(comentarioToDelete != null) {
            currentSession.remove(comentarioToDelete);
        }
    }
}
