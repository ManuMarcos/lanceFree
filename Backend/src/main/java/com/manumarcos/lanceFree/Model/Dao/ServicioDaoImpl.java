package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Servicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ServicioDaoImpl implements IServicioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findAll() {
        Session currrentSession = entityManager.unwrap(Session.class);
        Query<Servicio> getServicios = currrentSession.createQuery("from servicio", Servicio.class);
        return getServicios.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Servicio.class, id));
    }

    @Override
    @Transactional
    public Servicio save(Servicio servicio) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(servicio);
    }

    @Override
    @Transactional
    public Servicio update(Servicio servicio) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(servicio);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Servicio servicioToDelete = currentSession.get(Servicio.class, id);
        if(servicioToDelete != null) {
            currentSession.remove(servicioToDelete);
        }
    }
}
