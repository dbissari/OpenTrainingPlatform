/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.restcontroller;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.service.ICourseService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edemos
 */
@RestController
@RequestMapping("/api/course-session")
public class CourseRestController {
    
    @Autowired
    protected ICourseService courseService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Course> index() {
        return courseService.listAll();
    }
    
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Course get(@PathVariable("code") String code) {
        return courseService.getByCode(code);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Course create(@Valid @RequestBody Course course) {
        courseService.create(course);
        return course;
    }
}
