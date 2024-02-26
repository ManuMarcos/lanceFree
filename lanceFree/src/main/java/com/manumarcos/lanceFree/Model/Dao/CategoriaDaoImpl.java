package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaDaoImpl implements ICategoriaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Categoria> getQuery = currentSession.createQuery("from categoria", Categoria.class);

        return getQuery.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return Optional.ofNullable(currentSession.get(Categoria.class, id));
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(categoria);
    }

    @Override
    @Transactional
    public Categoria update(Categoria categoria) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(categoria);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Categoria categoriaToDelete = currentSession.get(Categoria.class, id);

        if(categoriaToDelete != null){
            currentSession.remove(categoriaToDelete);
        }
    }
}
