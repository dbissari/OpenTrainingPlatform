/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bright
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private IClientService clientService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("clients", clientService.listAll());
        
        return "client/index";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewForm(ModelMap model) {
        model.addAttribute("client", new Client());
        
        return "client/form";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String submitNewForm(@ModelAttribute("client") Client client) {
        clientService.create(client);
        
        return "redirect:/client";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Integer id, ModelMap model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        
        return "client/form";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String submitEditForm(@PathVariable("id") Integer id, @ModelAttribute("client") Client client) {
        clientService.update(client);
        
        return "redirect:/client";
    }
}
