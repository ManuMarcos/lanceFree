package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteDaoImpl implements IClienteDao{

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_EMAIL = "SELECT c FROM cliente c  WHERE c.email = :email";


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Cliente> getQuery = currentSession.createQuery("from cliente", Cliente.class);

        return getQuery.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return Optional.ofNullable(currentSession.get(Cliente.class, id));
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        TypedQuery<Cliente> typedQuery = entityManager.createQuery(FIND_BY_EMAIL, Cliente.class);
        typedQuery.setParameter("email", email);
        try {
            return Optional.of(typedQuery.getSingleResult());
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(cliente);
    }

    @Override
    @Transactional
    public Cliente update(Cliente cliente) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.merge(cliente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Cliente clienteToDelete = currentSession.get(Cliente.class, id);

        if(clienteToDelete != null) {
            currentSession.remove(clienteToDelete);
        }
    }
}
