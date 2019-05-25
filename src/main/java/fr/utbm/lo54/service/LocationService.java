/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.ILocationDao;
import fr.utbm.lo54.entity.Location;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edemos
 */
@Service
public class LocationService implements ILocationService {
    
    @Autowired
    private ILocationDao locationDao;

    @Override
    public void create(Location location) {
        locationDao.persist(location);
    }

    @Override
    public List<Location> listAll() {
        return locationDao.findAll();
    }

    @Override
    public Location getById(Integer id) {
        return locationDao.findById(id);
    }
}
