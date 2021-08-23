/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Purchased;
import com.moviesite.hibernate.entity.Review;
import com.moviesite.hibernate.util.Hibernate;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class ReviewEaoImpl implements ReviewEao {
    
     SessionFactory sessionFactory; 
     
      public ReviewEaoImpl() { 
        sessionFactory = Hibernate.getSessionFactory(); 
    }
     
     
    @Override
    public void create(Movie mov) {
        
        Session session = sessionFactory.openSession(); 
        session.beginTransaction(); 
       
        
        session.saveOrUpdate(mov); 
        
        session.getTransaction().commit(); 
        session.close(); 

    }

    @Override
    public void about(int i,String a,int m) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie1 = (Movie) session.get(Movie.class, m);
        Review r1=new Review(i, a,movie1);
        session.saveOrUpdate(r1);
        session.getTransaction().commit();
        session.close();

    }

   
    @Override
        public boolean dosompare(int movieId, int userId) {
        boolean access = false;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "FROM movie_purchased p WHERE p.movie.MovieId = :movie_id AND p.movie_registered_user.userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("movie_id", movieId);
            query.setParameter("register", userId);
            List<Purchased> purchased = query.list();
            if(!purchased.isEmpty()){
                access = true;
            }
            session.getTransaction().commit(); 
            session.close();
        }catch (Exception e) {}
        
        return access;
        
     
    
}
        
//        //----------------------------------------------------------
//     @Override
//    public float count(int id1) {
//     float List=1;
//     Session session = sessionFactory.openSession();
//            session.beginTransaction();
//        try {
//            String hql = "select avg(rate) from review E WHERE E.=MovieId :movie";
//            Query query = session.createQuery(hql);
//            query.setParameter("movie", id1);
//            List = (float) query.uniqueResult();
//            session.close();
//            return List;
//        } catch (Exception e) {
//        }
//
//        return List;
//    }
//        
//        
//



}
