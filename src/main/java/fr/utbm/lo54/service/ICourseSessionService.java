/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dto.CourseSessionDto;
import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bright
 */
public interface ICourseSessionService {
    
    public void create(CourseSession courseSession);
    
    public void register(CourseSession courseSession, Client client);
    
    public List<CourseSession> listAll();
    
    public List<CourseSessionDto> listAllAsDto();
    
    public CourseSession getById(Integer id);
    
    public CourseSessionDto getByIdAsDto(Integer id);
    
    public List<Client> listAllAttendeesByCourseSession(CourseSession courseSession);

    public List<CourseSession> listAllByCourseDateAndLocation(String courseKeyword, Date date, Integer locationId);
    
    public List<CourseSessionDto> listAllByCourseDateAndLocationAsDto(String courseKeyword, Date date, Integer locationId);
    
    public CourseSessionDto convertToDto(CourseSession courseSession);
}
