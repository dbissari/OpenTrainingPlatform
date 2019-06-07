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
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author dbissari
 */
@Entity
public class Course implements Serializable {
    
    @Id
    @Column(nullable = false, unique = true)
    @NotBlank
    @JsonView(SerializerViews.CourseSessionDetails.class)
    private String code;
    
    @Column(nullable = false, unique = true)
    @NotBlank
    @JsonView(SerializerViews.CourseSession.class)
    private String title;
    
    public Course() {
        
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return code + " : " + title;
    }
    
}
