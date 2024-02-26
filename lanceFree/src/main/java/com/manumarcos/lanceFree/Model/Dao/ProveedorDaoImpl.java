package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorDaoImpl implements IProveedorDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Proveedor> getProveedores = currentSession.createQuery("from proveedor", Proveedor.class);
        return getProveedores.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Proveedor> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Proveedor.class, id));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(proveedor);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Proveedor proveedorToDelete = currentSession.get(Proveedor.class, id);
        if(proveedorToDelete != null){
            currentSession.remove(proveedorToDelete);
        }
    }
}
