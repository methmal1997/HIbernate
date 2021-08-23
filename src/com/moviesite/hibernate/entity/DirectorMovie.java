/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Director_of_Movie")
public class DirectorMovie implements Serializable {
    
    private int Id;
    private Movie directormovie;
    private Directors director;
    
  

    public DirectorMovie(){
    }

    public DirectorMovie(Movie directormovie, Directors director) {
        this.directormovie = directormovie;
        this.director = director;
    }

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
  
   
    
    @ManyToOne
    @JoinColumn(name="Director_Id")

    public Directors getDirector() {
        return director;
    }

    public void setDirector(Directors director) {
        this.director = director;
    }
    
    
      
    @ManyToOne
    @JoinColumn(name="MovieId")
    public Movie getDirectormovie() {
        return directormovie;
    }

    public void setDirectormovie(Movie directormovie) {
        this.directormovie = directormovie;
    }
    
    
    
    
 
    }
    
   
