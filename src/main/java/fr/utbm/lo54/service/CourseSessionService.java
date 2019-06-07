/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.IClientDao;
import fr.utbm.lo54.dao.ICourseSessionDao;
import fr.utbm.lo54.dto.CourseSessionDto;
import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edemos
 */
@Service
public class CourseSessionService implements ICourseSessionService {

    @Autowired
    private ICourseSessionDao courseSessionDao;

    @Autowired
    private IClientDao clientDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(CourseSession courseSession) {
        courseSessionDao.persist(courseSession);
    }

    @Override
    public List<CourseSession> listAll() {
        return courseSessionDao.findAll();
    }

    @Override
    public CourseSession getById(Integer id) {
        return courseSessionDao.findById(id);
    }

    @Override
    public List<Client> listAllAttendeesByCourseSession(CourseSession courseSession) {
        return courseSessionDao.findAllAttendeesByCourseSession(courseSession);
    }

    @Override
    public List<CourseSession> listAllByCourseDateAndLocation(String courseKeyword, Date date, Integer locationId) {
        return courseSessionDao.findAllByCourseDateAndLocation(courseKeyword, date, locationId);
    }

    @Override
    public void register(CourseSession courseSession, Client client) {
        client.setCourseSession(courseSession);
        clientDao.persist(client);
    }

    @Override
    public List<CourseSessionDto> listAllAsDto() {
        return listAll().stream()
                .map(cs -> convertToDto(cs))
                .collect(Collectors.toList());
    }

    @Override
    public CourseSessionDto getByIdAsDto(Integer id) {
        return convertToDto(getById(id));
    }

    @Override
    public List<CourseSessionDto> listAllByCourseDateAndLocationAsDto(String courseKeyword, Date date, Integer locationId) {
        return listAllByCourseDateAndLocation(courseKeyword, date, locationId).stream()
                .map(cs -> convertToDto(cs))
                .collect(Collectors.toList());
    }

    @Override
    public CourseSessionDto convertToDto(CourseSession courseSession) {
        CourseSessionDto courseSessionDto = modelMapper.map(courseSession, CourseSessionDto.class);
        courseSessionDto.computeFillingPercentage();
        return courseSessionDto;
    }
}
