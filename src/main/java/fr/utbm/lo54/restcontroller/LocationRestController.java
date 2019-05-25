/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.restcontroller;

import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.service.ILocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edemos
 */
@RestController
@RequestMapping("/api/location")
public class LocationRestController {
    
    @Autowired
    private ILocationService locationService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Location> index() {
        return locationService.listAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable(value = "id") Integer id) {
        return locationService.getById(id);
    }
    
}
