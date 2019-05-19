/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.ICourseDao;
import fr.utbm.lo54.entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edemos
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    protected ICourseDao courseDao;
    
    @Override
    public void create(Course course) {
        courseDao.persist(course);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public List<Course> listAll() {
        return courseDao.findAll();
    }

    @Override
    public Course getByCode(String code) {
        return courseDao.findByCode(code);
    }
}
