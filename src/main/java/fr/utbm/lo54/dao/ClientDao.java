/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edemos
 */
@Repository
public class ClientDao implements IClientDao {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    @Override
    @Transactional
    public void persist(Client client) {
        entityManager.persist(client);
    }

    @Override
    @Transactional
    public void update(Client client) {
        entityManager.merge(client);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Client findById(Integer id) {
        return entityManager.find(Client.class, id);
    }
    
}
