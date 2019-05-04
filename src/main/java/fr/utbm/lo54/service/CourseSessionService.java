/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.CourseSession;
import java.util.List;

/**
 *
 * @author edemos
 */
public class CourseSessionService {
    public void createCourseSession(CourseSession courseSession) {
        // TODO: call persist() from dao
    }
    
    public void updateCourseSession(CourseSession courseSession) {
        // TODO: call update() from dao
    }
    
    public List<CourseSession> listCourseSessions() {
        // TODO: call findAll() from dao
        return null;
    }
    
    public List<CourseSession> listFutureCourseSessions() {
        // TODO: call findAllFuture() from dao
        return null;
    }
    
    public CourseSession detailsCourseSession(Integer id) {
        // TODO: call findById() from dao
        return null;
    }
    
    public void deleteCourseSession(Integer id) {
        // TODO: call delete() from dao
    }
}
