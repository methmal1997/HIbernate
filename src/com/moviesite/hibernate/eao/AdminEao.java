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

/**
 *
 * @author ASUS
 */
public interface AdminEao {
    void create(Admin ad);
    void saveOrUpdate(Admin aod);

    public void make(Movie all);

    public void create(Actors p);
    
    public void create(Directors p);

    public void make(Actors p1);

    public void Buy(Movie m2);

    public boolean login(int Id, String pssword);
    
   
    
 

 
    
   
}

