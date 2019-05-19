/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Location;
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
public class LocationDao implements ILocationDao {
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void persist(Location location) {
        entityManager.persist(location);
    }

    @Override
    @Transactional
    public void update(Location location) {
        entityManager.merge(location);
    }

    @Override
    public List<Location> findAll() {
        Query query = entityManager.createQuery("SELECT l FROM Location l", Location.class);
        return query.getResultList();
    }

    @Override
    public Location findById(Integer id) {
        return entityManager.find(Location.class, id);
    }
    
}
