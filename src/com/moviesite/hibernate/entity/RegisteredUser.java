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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "movie_registered_user")
public class RegisteredUser implements Serializable {
    
    private int userId; 
    private String Name;
    private String Email;
    private int age;
    private String password;
    
   
    private Collection<Purchased> purchased = new ArrayList();
   
   
    
    public RegisteredUser(){
    }

    public RegisteredUser(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public RegisteredUser(int userId, String Name, String Email, int age, String password) {
        this.userId = userId;
        this.Name = Name;
        this.Email = Email;
        this.age = age;
        this.password = password;
    }
    
    
    
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Basic(optional = false)
    @Column(name="FULL_NAME")
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    @Basic(optional = false)
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    @Basic(optional = false)
    @Column(name="Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Basic(optional = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   
    
 

    

   }
