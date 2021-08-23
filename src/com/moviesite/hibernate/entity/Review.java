/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author ASUS
 */

@Entity
public class Review implements Serializable {
    
   
    private int idreview;
    private int rate;
    private Purchased purchased;
    private Date rateDate;
    private String discription;
    private Movie movie;

    public Review() {
    }

    public Review(int rate, String discription, Movie movie) {
        this.rate = rate;
        this.discription = discription;
        this.movie = movie;
    }

   
  

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    @ManyToOne
    @JoinColumn(name = "Id")
    public Purchased getPurchased() {
        return purchased;
    }

    public void setPurchased(Purchased purchased) {
        this.purchased = purchased;
    }
    
        
    
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

  

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MovieId")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public int getIdreview() {
        return idreview;
    }

    public void setIdreview(int idreview) {
        this.idreview = idreview;
    }

    
    
    

}
