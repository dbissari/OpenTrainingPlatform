/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.utbm.lo54.util.SerializerViews;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author dbissari
 */
@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(value = { 
        SerializerViews.CourseSessionDetails.class,
        SerializerViews.Client.class})
    private Integer id;
    
    @Column(nullable = false)
    @NotBlank
    @JsonView(SerializerViews.Client.class)
    private String firstName;
    
    @Column(nullable = false)
    @NotBlank
    @JsonView(SerializerViews.Client.class)
    private String lastName;
    
    @Column(nullable = false)
    @NotBlank
    @JsonView(SerializerViews.Client.class)
    private String address;
    
    @Column(nullable = false)
    @NotBlank
    @JsonView(SerializerViews.Client.class)
    private String phone;
    
    @Column(nullable = false)
    @NotBlank
    @Email
    @JsonView(SerializerViews.Client.class)
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "course_session_id", nullable = false, referencedColumnName = "id")
    @JsonView(SerializerViews.CourseSessionClient.class)
    private CourseSession courseSession;
    
    public Client() {
        
    }

    public Client(String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
}
