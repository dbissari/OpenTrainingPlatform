/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.CourseSession;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bright
 */
@Repository
public class CourseSessionDao implements ICourseSessionDao {
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void persist(CourseSession courseSession) {
        entityManager.persist(courseSession);
    }

    @Override
    @Transactional
    public void update(CourseSession courseSession) {
        entityManager.merge(courseSession);
    }

    @Override
    public List<CourseSession> findAll() {
        Query query = entityManager.createQuery("SELECT cs FROM CourseSession cs", CourseSession.class);
        return query.getResultList();
    }

    @Override
    public CourseSession findById(Integer id) {
        return entityManager.find(CourseSession.class, id);
    }
    
}
