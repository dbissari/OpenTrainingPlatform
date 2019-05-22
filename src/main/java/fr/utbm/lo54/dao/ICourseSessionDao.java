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

/**
 *
 * @author bright
 */
public interface ICourseSessionDao {
    
    public void persist(CourseSession courseSession);

    public void update(CourseSession courseSession);

    public CourseSession findById(Integer id);

    public List<CourseSession> findAll();
    
    public List<Client> findAllAttendeesByCourseSession(CourseSession courseSession);
    
    public List<CourseSession> findAllByCourseDateAndLocation(String courseKeyword, Date date, Integer locationId);

    /*
    public List<CourseSession> findAllFuture();

    public CourseSession findById(Integer id);

    public void delete(Integer id);
    */
}
