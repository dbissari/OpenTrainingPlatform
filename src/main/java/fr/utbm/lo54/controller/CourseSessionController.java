/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.ICourseService;
import fr.utbm.lo54.service.ICourseSessionService;
import fr.utbm.lo54.service.ILocationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ICourseSessionService courseSessionService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ILocationService locationService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(DATE_FORMAT, true));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("courseSessions", courseSessionService.listAllAsDto());

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
    public String submitNewForm(@Valid @ModelAttribute("courseSession") CourseSession courseSession, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model
                    .addAttribute("courses", courseService.listAll())
                    .addAttribute("locations", locationService.listAll());
            
            return "course_session/form";
        }

        courseSessionService.create(courseSession);

        return "redirect:/course-session";
    }

    @RequestMapping(value = "/{id}/details", method = RequestMethod.GET)
    public String showDetails(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("courseSession", courseSessionService.getByIdAsDto(id));

        return "course_session/details";
    }

    @RequestMapping(value = "/{id}/register", method = RequestMethod.GET)
    public String showRegisterForm(@PathVariable("id") Integer id, ModelMap model) {
        model
                .addAttribute("courseSession", courseSessionService.getByIdAsDto(id))
                .addAttribute("client", new Client());

        return "course_session/register";
    }

    @RequestMapping(value = "/{id}/register", method = RequestMethod.POST)
    public String submitRegisterForm(@PathVariable("id") Integer id, @Valid @ModelAttribute("client") Client client, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("courseSession", courseSessionService.getByIdAsDto(id));
            return "course_session/register";
        }

        CourseSession courseSession = courseSessionService.getById(id);
        courseSessionService.register(courseSession, client);

        return "redirect:/course-session/" + id + "/details";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showSearch(ModelMap model, HttpServletRequest request) throws ParseException {
        String courseKeyword = request.getParameter("course_keyword");
        Date date = request.getParameter("date") == null || request.getParameter("date").equals("")
                ? null : DATE_FORMAT.parse(request.getParameter("date"));
        Integer locationId = request.getParameter("location_id") == null || request.getParameter("location_id").equals("")
                ? null : Integer.valueOf(request.getParameter("location_id"));

        model
                .addAttribute("courseSessions", courseSessionService.listAllByCourseDateAndLocationAsDto(courseKeyword, date, locationId))
                .addAttribute("locations", locationService.listAll())
                .addAttribute("courseKeyword", courseKeyword)
                .addAttribute("date", date != null ? DATE_FORMAT.format(date) : null)
                .addAttribute("locationId", locationId);

        return "course_session/search";
    }
}
