/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.dao;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author edemos
 */
public class ClientDao implements IClientDao {
    
    @Override
    public void persist(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
            
            System.out.println("Enregistrement effectué avec succès !");
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                    System.out.println("Enregistrement annulé !");
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he3) {
                    he3.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
            
            System.out.println("Client modifié avec succès !");
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                    System.out.println("Erreur lors de la modification annulé !");
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he3) {
                    he3.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Client> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Client> clients = null;
        try {
            session.beginTransaction();
            clients = session.createQuery("from Client").list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        
        return clients;
    }

    @Override
    public Client findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        try {
            session.beginTransaction();
            client = session.load(Client.class, id);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        
        return client;
    }

    @Override
    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        try {
            session.beginTransaction();
            client = session.load(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
    }
    
}
