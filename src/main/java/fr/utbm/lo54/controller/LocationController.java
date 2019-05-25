/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author edemos
 */
@Controller
@RequestMapping("/location")
public class LocationController {
    
    @Autowired
    private ILocationService locationService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("locations", locationService.listAll());
        
        return "location/index";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewForm(ModelMap model) {
        model.addAttribute("location", new Location());
        
        return "location/form";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String submitNewForm(@ModelAttribute("location") Location location) {
        locationService.create(location);
        
        return "redirect:/location";
    }
}
