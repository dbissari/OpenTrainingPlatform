/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Client;
import java.util.List;

/**
 *
 * @author bright
 */
public interface IClientService {
    
    public void create(Client client);
    
    public void update(Client client);
    
    public List<Client> listAll();
    
    public Client getById(Integer id);
}
