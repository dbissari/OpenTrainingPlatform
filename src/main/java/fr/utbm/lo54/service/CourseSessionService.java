/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.ICourseSessionDao;
import fr.utbm.lo54.entity.CourseSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edemos
 */
@Service
public class CourseSessionService implements ICourseSessionService{
    
    @Autowired
    private ICourseSessionDao courseSessionDao;

    @Override
    public void create(CourseSession courseSession) {
        courseSessionDao.persist(courseSession);
    }

    @Override
    public void update(CourseSession courseSession) {
        courseSessionDao.update(courseSession);
    }

    @Override
    public List<CourseSession> listAll() {
        return courseSessionDao.findAll();
    }

    @Override
    public CourseSession getById(Integer id) {
        return courseSessionDao.findById(id);
    }
}
