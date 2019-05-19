/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import java.util.List;

/**
 *
 * @author edemos
 */
public interface ICourseService {
    
    public void create(Course course);
    
    public void update(Course course);
    
    public List<Course> listAll();
    
    public Course getByCode(String code);
}
