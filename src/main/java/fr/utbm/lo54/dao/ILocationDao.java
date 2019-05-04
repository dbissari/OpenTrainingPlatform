/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Location;
import java.util.List;

/**
 *
 * @author bright
 */
public interface ILocationDao {
    
    public void persist(Location location);

    public void update(Location location);

    public List<Location> findAll();

    public Location findById(Integer id);

    public void delete(Integer id);
}
