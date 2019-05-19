/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author edemos
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    protected ICourseService courseService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("courses", courseService.listAll());
        return "course/index";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewForm(ModelMap model) {
        model.addAttribute("course", new Course());
        return "course/form";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String submitNewForm(@ModelAttribute("course") Course course) {
        courseService.create(course);
        
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/{code}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("code") String code, ModelMap model) {
        Course course = courseService.getByCode(code);
        model.addAttribute("course", course);
        
        return "course/form";
    }
    
    @RequestMapping(value = "/{code}/edit", method = RequestMethod.POST)
    public String submitEditForm(@PathVariable("code") String code, @ModelAttribute("course") Course course) {
        courseService.update(course);
        return "redirect:/course";
    }
}
