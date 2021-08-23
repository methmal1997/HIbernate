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
@Table(name = "Actors_of_Movie")
public class ActorMovie implements Serializable {
    
    private int Id;
    private Movie actormovie;
    private Actors actors;
    
  

    public ActorMovie(){
    }

    public ActorMovie(Movie actormovie, Actors actors) {
        this.actormovie = actormovie;
        this.actors = actors;
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
    @JoinColumn(name="MovieId")
    public Movie getActormovie() {
        return actormovie;
    }

    public void setActormovie(Movie actormovie) {
        this.actormovie = actormovie;
    }

    @ManyToOne
    @JoinColumn(name="Actor_Id")
    public Actors getActors() {
        return actors;
    }

    public void setActors(Actors actors) {
        this.actors = actors;
    }
    
    
    
    
    
   
    
}
