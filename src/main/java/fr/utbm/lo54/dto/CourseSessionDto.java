/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.util.SerializerViews;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bright
 */
public class CourseSessionDto implements Serializable {
    
    @JsonView(SerializerViews.CourseSession.class)
    private Integer id;
    
    @JsonView(SerializerViews.CourseSession.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    
    @JsonView(SerializerViews.CourseSession.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    
    @JsonView(SerializerViews.CourseSession.class)
    private Integer max;
    
    @JsonView(SerializerViews.CourseSession.class)
    private Double fillingPercentage;
    
    @JsonView(SerializerViews.CourseSession.class)
    private Course course;
    
    @JsonView(SerializerViews.CourseSession.class)
    private Location location;
    
    @JsonView(SerializerViews.CourseSessionDetails.class)
    @JacksonXmlElementWrapper(localName = "attendees")
    @JacksonXmlProperty(localName = "attendee")
    private List<Client> attendees;
    
    public void computeFillingPercentage() {
        this.fillingPercentage = 100 * (double) this.attendees.size() / (double) this.max;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getFillingPercentage() {
        return fillingPercentage;
    }

    public void setFillingPercentage(Double fillingPercentage) {
        this.fillingPercentage = fillingPercentage;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Client> getAttendees() {
        return attendees;
    }
    
    public void setAttendees(List<Client> attendees) {
        this.attendees = attendees;
    }
    
    @JsonView(SerializerViews.CourseSessionList.class)
    public Integer getAttendeesCount() {
        return this.attendees.size();
    }
}
