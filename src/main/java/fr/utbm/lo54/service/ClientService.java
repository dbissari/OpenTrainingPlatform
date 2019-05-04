/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.service;

import fr.utbm.lo54.dao.ClientDao;
import fr.utbm.lo54.dao.IClientDao;
import fr.utbm.lo54.entity.Client;
import java.util.List;

/**
 *
 * @author edemos
 */
public class ClientService {
    
    private IClientDao clientDao = new ClientDao();
    
    public void createClient(Client client) {
        clientDao.persist(client);
    }
    
    public void updateClient(Client client) {
        clientDao.update(client);
    }
    
    public List<Client> listClients() {
        return clientDao.findAll();
    }
    
    public Client detailsClient(Integer id) {
        return clientDao.findById(id);
    }
    
    public void deleteClient(Integer id) {
        clientDao.delete(id);
    }
}
