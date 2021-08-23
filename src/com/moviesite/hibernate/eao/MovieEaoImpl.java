/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Review;
import com.moviesite.hibernate.util.Hibernate;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class MovieEaoImpl implements MovieEao {
    
    SessionFactory sessionFactory; 

    public MovieEaoImpl() { 
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
     public void saveOrUpdate(Movie mov) { 
        
        Session session = sessionFactory.openSession(); 
        session.beginTransaction(); 
        
    
        
        session.saveOrUpdate(mov); 
        
        session.getTransaction().commit(); 
        session.close();
    }
     
       @Override
    public List<Movie> getSearch(String movie) {
     List<Movie> movieList = null;
     Session session = sessionFactory.openSession();
            session.beginTransaction();
        try {
            String hql = "FROM Movie m WHERE m.movieName = :movie_name";
            Query query = session.createQuery(hql);
            query.setParameter("movie_name", movie);
            movieList = query.list();
            session.close();
            return movieList;
        } catch (Exception e) {
        }

        return movieList;}
   
       @Override
    public List<Movie> getMovies() {
        List<Movie> movieList = null;
        try {

            String hql = "FROM Movie m";
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            movieList = session.createQuery(hql).list();
             
            session.close();

            return movieList;
        } catch (Exception e) {
        }

        return movieList;
    }
    
    @Override
    public Movie viewSingleMovie(int movieId) {
        Movie movie = null;
        try {
            Session session = sessionFactory.openSession();
            movie = (Movie) session.get(Movie.class, movieId);
            session.close();
        } catch (Exception e) {
        }
        return movie;
    }
    
        @Override
    public List<Review> selectedReviews(int movieId) {
        List<Review> list = null; 
        try{
            
        String hql = "FROM Review r WHERE r.movie.movieId = :movie_id"; 
        Session session = sessionFactory.openSession(); 
        Query query = session.createQuery(hql); 
        query.setParameter("movie_id", movieId); 
        list = query.list(); 
        session.close(); 
        
        }catch(Exception e){}
        
        return list;
    }
}
