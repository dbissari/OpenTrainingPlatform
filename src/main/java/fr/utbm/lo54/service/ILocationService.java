/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Location;
import java.util.List;

/**
 *
 * @author edemos
 */
public interface ILocationService {
    
    public void create(Location location);
    
    public List<Location> listAll();
    
    public Location getById(Integer id);
}
