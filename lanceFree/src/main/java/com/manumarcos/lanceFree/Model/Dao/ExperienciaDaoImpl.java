package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Experiencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienciaDaoImpl implements IExperienciaDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public List<Experiencia> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Experiencia> getExperiencias = currentSession.createQuery("from experiencia", Experiencia.class);
        return getExperiencias.getResultList();
    }

    @Override
    public Optional<Experiencia> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Experiencia.class, id));
    }

    @Override
    @Transactional
    public Experiencia save(Experiencia experiencia) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(experiencia);
    }

    @Override
    @Transactional
    public Experiencia update(Experiencia experiencia) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(experiencia);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Experiencia experienciaToDelete = currentSession.get(Experiencia.class, id);
        if(experienciaToDelete != null){
            currentSession.remove(experienciaToDelete);
        }
    }
}
