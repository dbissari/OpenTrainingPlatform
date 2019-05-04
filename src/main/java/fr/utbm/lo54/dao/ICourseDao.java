/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Course;
import java.util.List;

/**
 *
 * @author bright
 */
public interface ICourseDao {
    
    public void persist(Course course);

    public void update(Course course);

    public List<Course> findAll();

    public Course findByCode(String code);

    public void delete(String code);
}
