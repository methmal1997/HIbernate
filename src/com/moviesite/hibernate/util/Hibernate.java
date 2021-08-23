/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ASUS
 */
public class Hibernate{
    
    private static SessionFactory sessionFactory;
    
    private Hibernate(){
    }
    
    public static synchronized SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            sessionFactory=new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }
}
