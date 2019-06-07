/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.utbm.lo54.util.CustomListSerializer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dbissari
 */
@Entity
public class CourseSession implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date startDate;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date endDate;
    
    @Column(nullable = false)
    @NotNull
    @Min(10)
    private Integer max;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, referencedColumnName = "code")
    @NotNull
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false, referencedColumnName = "id")
    @NotNull
    private Location location;
    
    @OneToMany(mappedBy = "courseSession")
    @JsonSerialize(using = CustomListSerializer.class)
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

    public void setAttendees(List<Client> attendees) {
        this.attendees = attendees;
    }
    
}
