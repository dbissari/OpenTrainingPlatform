/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Client;
import java.util.List;

/**
 *
 * @author bright
 */
public interface IClientDao {
    
    public void persist(Client client);

    public void update(Client client);

    public List<Client> findAll();

    public Client findById(Integer id);
}
