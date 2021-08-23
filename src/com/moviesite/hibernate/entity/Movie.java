/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import sun.font.EAttribute;

/**
 *
 * @author ASUS
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "release_year", "MovieName"}) })
public class Movie implements Serializable {
    
    
    private int MovieId; 
    private String MovieName; 
    private String Gendre;
    private int Runtime; 
    private int release_year;
    private float Price;
    
    private Admin admin;
  
    private Set<ActorMovie> actorMovie=new HashSet<>();
    private Set<DirectorMovie> directorMovies=new HashSet<>();
    private Collection<Purchased> purchased = new ArrayList();
    private Collection<Review> review = new ArrayList();
   

    public Movie() {
    }

    public Movie(String MovieName, String Gendre, int Runtime, int release_year, float Price) {
        this.MovieName = MovieName;
        this.Gendre = Gendre;
        this.Runtime = Runtime;
        this.release_year = release_year;
        this.Price = Price;
    }

    

  
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }
    
     @Column(name = "MovieName")
    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public int getRuntime() {
        return Runtime;
    }

    public void setRuntime(int Runtime) {
        this.Runtime = Runtime;
    }
    @Column(name = "release_year")
    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
   
    
    @OneToMany(mappedBy = "actormovie", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<ActorMovie> getActorMovie() {
        return actorMovie;
    }

    public void setActorMovie(Set<ActorMovie> actorMovie) {
        this.actorMovie = actorMovie;
    }
    
    public  void addActors(ActorMovie actormovie){
        this.actorMovie.add(actormovie);
    
    }

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AdminId")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    @OneToMany(mappedBy = "directormovie", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<DirectorMovie> getDirectorMovies() {
        return directorMovies;
    }

    public void setDirectorMovies(Set<DirectorMovie> directorMovies) {
        this.directorMovies = directorMovies;
    }
   
    public  void addDirectors(DirectorMovie directormovie){
        this.directorMovies.add(directormovie);
    
    }
    
    
    public String getGendre() {
        return Gendre;
    }

    public void setGendre(String Gendre) {
        this.Gendre = Gendre;
    }

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    public Collection<Purchased> getPurchased() {
        return purchased;
    }

    public void setPurchased(Collection<Purchased> purchased) {
        this.purchased = purchased;
    }

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    public Collection<Review> getReview() {
        return review;
    }

    public void setReview(Collection<Review> review) {
        this.review = review;
    }

    
    
    
    
    
    
    
    
   
}
