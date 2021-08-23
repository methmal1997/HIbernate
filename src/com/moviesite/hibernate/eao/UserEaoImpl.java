/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Purchased;
import com.moviesite.hibernate.entity.RegisteredUser;
import com.moviesite.hibernate.entity.Review;
import com.moviesite.hibernate.util.Hibernate;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class UserEaoImpl implements UserEao {

    SessionFactory sessionFactory;

    public UserEaoImpl() {
        sessionFactory = Hibernate.getSessionFactory();
    }

  

    @Override
    public void create(RegisteredUser emp) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(emp);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveOrUpdate(RegisteredUser emp) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(emp);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void create(Purchased p1) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void comment(Review p1) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(p1);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean login(int Id, String pssword) {
        boolean access = false;
        RegisteredUser user;
        try {
            Session session = sessionFactory.openSession();
            user = (RegisteredUser) session.get(RegisteredUser.class, Id);
            if (user != null && user.getPassword().equals(pssword)) {
                access = true;
                return access;
            }
            else{}
        } catch (Exception ignore) {
           
            
        }
        return access;
    }
    
    
    @Override
    public List<RegisteredUser> logSearch(String s) {
     List<RegisteredUser> List = null;
     Session session = sessionFactory.openSession();
            session.beginTransaction();
        try {
            String hql = "FROM movie_registered_user m WHERE m.Name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", s);
            List = query.list();
            session.close();
            return List;
        } catch (Exception e) {
        }

        return List;}
   
}
