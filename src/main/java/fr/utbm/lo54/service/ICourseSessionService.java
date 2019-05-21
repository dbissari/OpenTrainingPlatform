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
 * @author bright
 */
public interface ICourseSessionService {
    
    public void create(CourseSession courseSession);
    
    public void update(CourseSession courseSession);
    
    public List<CourseSession> listAll();
    
    public CourseSession getById(Integer id);
    
}
