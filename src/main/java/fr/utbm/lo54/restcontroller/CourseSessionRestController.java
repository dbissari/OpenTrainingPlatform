/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.restcontroller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.utbm.lo54.dto.CourseSessionDto;
import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.ICourseSessionService;
import fr.utbm.lo54.util.SerializerViews;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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
public class CourseSessionRestController {

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    @Autowired
    protected ICourseSessionService courseSessionService;
    
    @JsonView(SerializerViews.CourseSessionList.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<CourseSessionDto> index() {
        return courseSessionService.listAllAsDto();
    }
    
    @JsonView(SerializerViews.CourseSessionDetails.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CourseSessionDto get(@PathVariable("id") Integer id) {
        return courseSessionService.getByIdAsDto(id);
    }
    
    @JsonView(SerializerViews.Client.class)
    @RequestMapping(value = "/{id}/attendees", method = RequestMethod.GET)
    public List<Client> attendees(@PathVariable("id") Integer id) {
        return courseSessionService.getById(id).getAttendees();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CourseSessionDto create(@Valid @RequestBody CourseSession courseSession) {
        courseSessionService.create(courseSession);
        return courseSessionService.convertToDto(courseSession);
    }

    @JsonView(SerializerViews.CourseSessionClient.class)
    @RequestMapping(value = "/{id}/register", method = RequestMethod.POST)
    public Client register(@PathVariable("id") Integer id, @Valid @RequestBody Client client) {
        CourseSession courseSession = courseSessionService.getById(id);
        courseSessionService.register(courseSession, client);
        return client;
    }
    
    @JsonView(SerializerViews.CourseSessionList.class)
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<CourseSessionDto> filter(ModelMap model, HttpServletRequest request) throws ParseException {
        String courseKeyword = request.getParameter("course_keyword");
        Date date = request.getParameter("date") == null || request.getParameter("date").equals("")
                ? null : DATE_FORMAT.parse(request.getParameter("date"));
        Integer locationId = request.getParameter("location_id") == null || request.getParameter("location_id").equals("")
                ? null : Integer.valueOf(request.getParameter("location_id"));

        return courseSessionService.listAllByCourseDateAndLocationAsDto(courseKeyword, date, locationId);
    }
}
