/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author dbissari
 */
public class CourseSession implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(nullable = false)
    private Integer max;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, referencedColumnName = "code")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false, referencedColumnName = "id")
    private Location location;
    
    @ManyToMany
    private List<Client> attendees;
    
    public CourseSession() {
        this.attendees = new ArrayList<>();
    }

    public CourseSession(Date startDate, Date endDate, Integer max, Course course, Location location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
        this.attendees = new ArrayList<>();
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

    public void addAttendee(Client attendee) {
        attendees.add(attendee);
        attendee.getCourseSessions().add(this);
    }

    public void removeAttendee(Client attendee) {
        attendees.remove(attendee);
        attendee.getCourseSessions().remove(this);
    }
    
}
