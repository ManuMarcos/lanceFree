package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Contratacion;
import com.manumarcos.lanceFree.Model.Entity.ContratacionKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ContratacionDaoImpl implements IContratacionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Contratacion> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Contratacion> getQuery = currentSession.createQuery("from contratacion", Contratacion.class);
        return getQuery.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contratacion> findById(ContratacionKey id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Contratacion.class, id));
    }

    @Override
    @Transactional
    public Contratacion save(Contratacion contratacion) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(contratacion);
    }

    @Override
    @Transactional
    public Contratacion update(Contratacion contratacion) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(contratacion);
    }

    @Override
    @Transactional
    public void deleteById(ContratacionKey id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Contratacion contratacionToDelete = currentSession.get(Contratacion.class, id);

        if(contratacionToDelete != null) {
            currentSession.remove(contratacionToDelete);
        }
    }
}
