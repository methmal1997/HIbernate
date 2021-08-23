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
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UserEao {
    
    void create(RegisteredUser emp); 
    
    void saveOrUpdate(RegisteredUser emp);


    public boolean login(int Id, String pssword);
    
    List<RegisteredUser> logSearch(String emp);

    public void create(Purchased p1);

    public void comment(Review r3);
    
  
}
