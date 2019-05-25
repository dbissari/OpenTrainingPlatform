/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import java.util.Date;
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
    @Transactional
    public List<CourseSession> findAll() {
        Query query = entityManager.createQuery("SELECT cs FROM CourseSession cs", CourseSession.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public CourseSession findById(Integer id) {
        return entityManager.find(CourseSession.class, id);
    }

    @Override
    @Transactional
    public List<Client> findAllAttendeesByCourseSession(CourseSession courseSession) {
        Query query = entityManager.createQuery("SELECT c FROM Client c WHERE c.courseSession = :courseSession", Client.class);
        query.setParameter("courseSession", courseSession);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<CourseSession> findAllByCourseDateAndLocation(String courseKeyword, Date date, Integer locationId) {
        String queryString = "SELECT cs FROM CourseSession cs JOIN cs.course c JOIN cs.location l WHERE 1=1";
        if(courseKeyword != null && !courseKeyword.equals(""))
            queryString += " AND c.title LIKE :courseKeyword";
        if(date != null)
            queryString += " AND :date BETWEEN cs.startDate AND cs.endDate";
        if(locationId != null)
            queryString += " AND l.id = :locationId";
        
        Query query = entityManager.createQuery(queryString, CourseSession.class);
        if(courseKeyword != null && !courseKeyword.equals(""))
            query.setParameter("courseKeyword", '%' + courseKeyword + '%');
        if(date != null)
            query.setParameter("date", date);
        if(locationId != null)
            query.setParameter("locationId", locationId);
        
        return query.getResultList();
    }
    
}
