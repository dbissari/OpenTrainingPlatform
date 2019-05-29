/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.restcontroller;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.ICourseSessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edemos
 */
@RestController
@RequestMapping("/api/session")
public class CourseSessionRestController {
    
    @Autowired
    protected ICourseSessionService courseSessionService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<CourseSession> index() {
        return courseSessionService.listAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CourseSession get(@PathVariable("id") Integer id) {
        return courseSessionService.getById(id);
    }
}
