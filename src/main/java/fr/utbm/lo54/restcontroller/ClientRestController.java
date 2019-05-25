/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.restcontroller;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.service.IClientService;
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
@RequestMapping("/api/client")
public class ClientRestController {
    
    @Autowired
    private IClientService clientService;
    
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public Client show(@PathVariable(value = "id") Integer id) {
        return clientService.getById(id);
    }
    
}
