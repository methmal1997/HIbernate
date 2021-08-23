/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "Directors_Table")
public class Directors implements Serializable {
    
    private int Director_Id; 
    private String Name;
    private String Gender;
  
   private Admin admin;
   private Set<DirectorMovie> directorMovie=new HashSet<>();
    
    public Directors(){
    }

    public Directors(String Name, String Gender) {
        this.Name = Name;
        this.Gender = Gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDirector_Id() {
        return Director_Id;
    }

    public void setDirector_Id(int Director_Id) {
        this.Director_Id = Director_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

     
 
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AdminId")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    public Set<DirectorMovie> getDirectorMovie() {
        return directorMovie;
    }

    public void setDirectorMovie(Set<DirectorMovie> directorMovie) {
        this.directorMovie = directorMovie;
    }
    

   }
