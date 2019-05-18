/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.IClientDao;
import fr.utbm.lo54.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edemos
 */
@Service
public class ClientService implements IClientService {
    
    @Autowired
    private IClientDao clientDao;
    
    @Override
    public void create(Client client) {
        clientDao.persist(client);
    }
    
    @Override
    public void update(Client client) {
        clientDao.update(client);
    }
    
    @Override
    public List<Client> listAll() {
        return clientDao.findAll();
    }
    
    @Override
    public Client getById(Integer id) {
        return clientDao.findById(id);
    }
    
}
