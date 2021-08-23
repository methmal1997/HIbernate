/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Admin_Table")
public class Admin implements Serializable {
    
    private int AdminId; 
    private String Name;
    private String password;
    
    private List<Movie> movie;
    private List<Actors> actors;
    private List<Directors> director;
   
    
    public Admin(){
    }

    public Admin(int AdminId, String Name, String password) {
        this.AdminId = AdminId;
        this.Name = Name;
        this.password = password;
    }

   
    @Id
    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int AdminId) {
        this.AdminId = AdminId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "admin")
    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
    
    @OneToMany(mappedBy = "admin")
    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }
    
    @OneToMany(mappedBy = "admin")
    public List<Directors> getDirector() {
        return director;
    }

    public void setDirector(List<Directors> director) {
        this.director = director;
    }
    
 
    
    
}