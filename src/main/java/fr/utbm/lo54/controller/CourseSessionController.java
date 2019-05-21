/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.ICourseService;
import fr.utbm.lo54.service.ICourseSessionService;
import fr.utbm.lo54.service.ILocationService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bright
 */
@Controller
@RequestMapping("/course-session")
public class CourseSessionController {
    
    @Autowired
    private ICourseSessionService courseSessionService;
    
    @Autowired
    private ICourseService courseService;
    
    @Autowired
    private ILocationService locationService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("courseSessions", courseSessionService.listAll());
        
        return "course_session/index";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewForm(ModelMap model) {
        model
                .addAttribute("courseSession", new CourseSession())
                .addAttribute("courses", courseService.listAll())
                .addAttribute("locations", locationService.listAll());
        
        return "course_session/form";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String submitNewForm(@ModelAttribute("courseSession") CourseSession courseSession) {
        courseSessionService.create(courseSession);
        
        return "redirect:/course-session";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Integer id, ModelMap model) {
        CourseSession courseSession = courseSessionService.getById(id);
        model
                .addAttribute("courseSession", courseSession)
                .addAttribute("courses", courseService.listAll())
                .addAttribute("locations", locationService.listAll());
        
        return "course_session/form";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String submitEditForm(@PathVariable("id") Integer id, @ModelAttribute("courseSession") CourseSession courseSession) {
        courseSessionService.update(courseSession);
        
        return "redirect:/course-session";
    }
}
