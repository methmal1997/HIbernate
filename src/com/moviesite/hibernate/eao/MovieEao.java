/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.eao;

import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Review;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface MovieEao {
    
    void create(Movie emp); 
    void saveOrUpdate(Movie emp);
    List<Movie> getSearch(String movieName);
    List<Movie> getMovies();

     Movie viewSingleMovie(int movieId);
     List<Review> selectedReviews(int movieId); 
  
}
