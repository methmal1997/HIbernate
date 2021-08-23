/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Actors;
import com.moviesite.hibernate.entity.Admin;
import com.moviesite.hibernate.entity.Directors;
import com.moviesite.hibernate.entity.Movie;

import com.moviesite.hibernate.util.Hibernate;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class AdminEaoImpl implements AdminEao {

    SessionFactory sessionFactory;

    public AdminEaoImpl() {
        sessionFactory = Hibernate.getSessionFactory();
    }

    @Override
    public void create(Admin aod) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(aod);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void create(Actors p) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(p);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveOrUpdate(Admin aod) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(aod);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void make(Movie all) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(all);

        session.close();
    }

    @Override
    public void make(Actors all) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(all);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void create(Directors d) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(d);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void Buy(Movie all) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(all);

        session.close();
    }

    @Override
    public boolean login(int Id, String pssword) {
        boolean access = false;
        Admin user;
        try {
            Session session = sessionFactory.openSession();
            user = (Admin) session.get(Admin.class, Id);
            if (user != null && user.getPassword().equals(pssword)) {
                access = true;
                return access;
            }
            else{}
        } catch (Exception ignore) {
           
            
        }
        return access;
    }
   
}
    
 

