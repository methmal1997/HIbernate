/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Movie_purchased")

public class Purchased implements Serializable{
    
    
    private int Id;
    private Movie movie;
    private RegisteredUser user;
    private Collection<Review> review = new ArrayList();
    
    
    public Purchased(){
    }

    public Purchased(Movie movie, RegisteredUser user) {
        this.movie = movie;
        this.user = user;
    }

   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }
    
    
    public void setId(int Id) {
        this.Id = Id;
    }
    
  
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }
    
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MovieId")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    @OneToMany(mappedBy = "purchased", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    public Collection<Review> getReview() {
        return review;
    }

    public void setReview(Collection<Review> review) {
        this.review = review;
    }
    
    
    
    
    
    
}
