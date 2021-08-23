/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Review;
/**
 *
 * @author ASUS
 */

public interface ReviewEao {
    void create(Movie emp);
   
//    public float count(int id);

    public boolean dosompare(int move, int use);

    public void about(int i, String gfgfngn, int i0);
    
}
