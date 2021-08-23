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
@Table(name = "Actors_Table")
public class Actors implements Serializable {
    
    private int Actor_Id; 
    private String Name;
    private String Gender;
    private int age;
    
    private   Admin admin;
    private Set<ActorMovie> actorMovie=new HashSet<>();
    
    public Actors(){
    }

    public Actors(String Name, String Gender, int age) {
        this.Name = Name;
        this.Gender = Gender;
        this.age = age;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getActor_Id() {
        return Actor_Id;
    }

    public void setActor_Id(int Actor_Id) {
        this.Actor_Id = Actor_Id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 
  
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AdminId")
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    @OneToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    public Set<ActorMovie> getActorMovie() {
        return actorMovie;
    }

    public void setActorMovie(Set<ActorMovie> actorMovie) {
        this.actorMovie = actorMovie;
    }
     public  void addActors(ActorMovie actormovie){
        this.actorMovie.add(actormovie);
    
    }

     
    

   }
