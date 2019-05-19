/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Course;
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
public class CourseDao implements ICourseDao {
    
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void persist(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public List<Course> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }

    @Override
    public Course findByCode(String code) {
        return entityManager.find(Course.class, code);
    }
    
}
