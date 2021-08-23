/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviesite.hibernate.client;

import com.moviesite.hibernate.eao.AdminEao;
import com.moviesite.hibernate.eao.AdminEaoImpl;
import com.moviesite.hibernate.eao.MovieEao;
import com.moviesite.hibernate.eao.MovieEaoImpl;
import com.moviesite.hibernate.eao.ReviewEao;
import com.moviesite.hibernate.eao.ReviewEaoImpl;
import com.moviesite.hibernate.eao.UserEao;
import com.moviesite.hibernate.eao.UserEaoImpl;
import com.moviesite.hibernate.entity.ActorMovie;
import com.moviesite.hibernate.entity.Actors;
import com.moviesite.hibernate.entity.Admin;
import com.moviesite.hibernate.entity.DirectorMovie;
import com.moviesite.hibernate.entity.Directors;
import com.moviesite.hibernate.entity.Movie;
import com.moviesite.hibernate.entity.Purchased;
;
import com.moviesite.hibernate.entity.RegisteredUser;
import com.moviesite.hibernate.entity.Review;
import com.moviesite.hibernate.util.Hibernate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;

/**
 *
 * @author ASUS
 */


public class main {

    public static void main(String[] args) {

        Scanner window = new Scanner(System.in);
        //Greeting
        System.out.println("\\\\  WELCOME TO THE GLOBAL MOVIES   ////");

        UserEao empEao = new UserEaoImpl();
        MovieEao movieEao = new MovieEaoImpl();
        AdminEao adEao = new AdminEaoImpl();
        ReviewEao rdEao=new ReviewEaoImpl();

        System.out.println("---------------Welcome page---------------");

        String Name,Email,Gender,u1,um1;
        int Id,ida,Year,Runtime,Age,changer;
        int Idu=1;
        float price,rate;
        String answer,Password;
        String Gendre = "Drama";
        Boolean a = true;
        Boolean b=false;
        Boolean log1 = false;
        Boolean c = true;
        Boolean normal = true;
        Boolean high = true;

        while (a) {
            System.out.println("Welcome Please select..(admin/user).");
            answer = window.nextLine();
            if (answer.equals("admin")) {
                System.out.println("----------------------Admin page------------------------");
                normal = false;
                break;
            } else if (answer.equals("user")) {
                System.out.println("-----------user page--------------");
                high=false;
                break;
            } else {
                System.out.println("Enter correct Answer...!");
            }

        }
        
        
//------------------------------------------------------------Start andmin--------------------------------------------------------------------
        while (a && high) {
            System.out.println("Do you have an admin Account?(yes/no)");
            answer = window.nextLine();

            if (answer.equals("no")) {

                System.out.println("//////////////////////////////Admin account create\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println("Enter your Name : ");
                Name = window.nextLine();
                System.out.println("Enter phone no : ");
                Id = window.nextInt();
                System.out.println("Ok ");
                Gender = window.nextLine();
                System.out.println("Enter Password : ");
                Password = window.nextLine();

                Admin a2 = new Admin(Id, Name, Password);
                adEao.create(a2);
                System.out.println("You created ADMIN account succesfully......");
            }
            if (answer.equals("yes")) {
                System.out.println("////////////////////////Admin /login page\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\....");
                break;
            } else {
                System.out.println("Enter correct Answer...!");

            }
        }
   

        
        

        while (a && high) {
            System.out.println("----------------------");
            break;
        }
         while (a && high) {

            System.out.println("Enter  Admin your detail");

            System.out.println("Enter Phone no : ");
            Id = window.nextInt();
            System.out.println("------------------------------------------");
            Name = window.nextLine();
            System.out.println("Enter Password : ");
            Password = window.nextLine();
            AdminEao a1 = new AdminEaoImpl();
            Boolean ad = a1.login(Id, Password);
            System.out.println(ad);
            if (ad == true) {
                log1=true;
                System.out.println("logged!");
                break;
            }
            System.out.println("Wrong name or password.try again");
        }
            
              
         while(log1){
         System.out.println("-----------------////////////////////////////Admin you can do Following Things...--------------------");  
         System.out.println("Enter 1 to Add Movie");  
         System.out.println("Enter 2 to View All ");  
         System.out.println("Enter 3 to "); 
            System.out.println("Chooose: ");
            changer = window.nextInt();
            if (changer == 1) {
                while (a) {

                    System.out.println("Create Movie");
                    System.out.println("////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                    System.out.println("Enter movie Name : ");
                    Name = window.nextLine();
                    System.out.println("Enter movie Name : ");
                    Name = window.nextLine();
                    System.out.println("Default gendre is Drama.Do you want to add more?(yes/no)");
                    answer = window.nextLine();
                    while (c) {
                        if (answer.equals("yes")) {
                            System.out.println("Enter new Gendre");
                            String s1 = window.nextLine();
                            Gendre = Gendre + " " + s1;
                            System.out.println("Do you want to add more?(yes/no)");
                            answer = window.nextLine();
                        } else {
                            break;
                        }

                    }

                    System.out.println("Enter Year : ");
                    Year = window.nextInt();
                    System.out.println("Enter Runtime : ");
                    Runtime = window.nextInt();
                    System.out.println("Enter Price : ");
                    price = window.nextFloat();
                    Movie m1 = new Movie(Name, Gendre, Runtime, Year, price);

                    System.out.println("Enter Director");
                    System.out.println("now start: ");
                    Gendre = window.nextLine();
                    System.out.println("Enter Director Name: ");
                    Name = window.nextLine();
                    System.out.println("Enter Director'Gender : ");
                    Gender = window.nextLine();
                    Directors d1 = new Directors(Name, Gender);

                    adEao.create(d1);
                    DirectorMovie dm1 = new DirectorMovie(m1, d1);
                    m1.addDirectors(dm1);
                    adEao.make(m1);
                    System.out.println("Enter a Director!");

                    System.out.println("Enter Actor");
                    System.out.println("Enter Actor Name : ");
                    Name = window.nextLine();
                    System.out.println("Enter Actor's Gender : ");
                    Gender = window.nextLine();
                    System.out.println("Enter Actor's Age : ");
                    Age = window.nextInt();

                    Actors p1 = new Actors(Name, Gender, Age);
                    adEao.create(p1);
                    ActorMovie am1 = new ActorMovie(m1, p1);
                    p1.addActors(am1);
                    adEao.make(p1);
                    System.out.println("Movie Created..!");
                    System.out.println("Nother try?(Yes/no)");
                    answer = window.nextLine();
                    System.out.println("Nother try?(Yes/no)");
                    answer = window.nextLine();
                    if (answer.equals("no")) {
                        break;
                    }

                }
            }
            
                  

            if (changer == 2) {
                while (a) {

                    SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory();

                    Session session = sessionFactory.openSession();
                    session.beginTransaction();
                    List<Movie> movieList = movieEao.getMovies();
                    for (Movie m : movieList) {
                        ;
                        System.out.println(m.getMovieName() + "  -     price " + m.getPrice() + "  -    Category " + m.getGendre() + "  -     " + "movieid " + m.getMovieId());
                    }
                    session.getTransaction().commit();
                    session.close();
                    break;
                }
        
        }}
      

         
       

//        while (c) {
//            float m = rdEao.count(1);
//            System.out.println(m);
//            break;
//        }

        ///review---------------------------
       

      


//
//        System.out.println("Enter your Name : ");
//        Name = window.nextLine();
//        System.out.println("Enter Password : ");
//        Password = window.nextLine();
//        AdminEao a1 = new AdminEaoImpl();
//         String t = a1.test(Name, Password);
//        System.out.println(t);
//---------------------------------------------------admin part end----------------------------------------------------------------------------------------------
        while (a) {
            System.out.println("Do you have a user Account?(yes/no)");
            answer = window.nextLine();

            if (answer.equals("no")) {

                UserEao userEao = new UserEaoImpl();
                System.out.println("Enter your nationalId no(Without V) : ");
                Id = window.nextInt();
                System.out.println("V ");
                Gendre = window.nextLine();
                System.out.println("Enter your Name : ");
                Name = window.nextLine();
                System.out.println("Enter Password : ");
                Password = window.nextLine();
                System.out.println("Enter Email : ");
                Email = window.nextLine();
                System.out.println("Enter your Age : ");
                Age = window.nextInt();

                RegisteredUser emp = new RegisteredUser(Id, Name, Email, Age, Password);
                userEao.create(emp);
                System.out.println("You created succesfully......");

                System.out.println("Then login....");
               
                break;

            } else if (answer.equals("yes")) {
                System.out.println("Then login....");
                
                break;

            } else {
                System.out.println("Enter correct Answer...!");

            }
        }

        while (a) {
            UserEao r1 = new UserEaoImpl();
            System.out.println("Enter your user detail");

            System.out.println("Enter your NationalId    (without V)");
            Idu = window.nextInt();
            System.out.println("V ");
            Name = window.nextLine();
            System.out.println("Enter Password : ");
            Password = window.nextLine();

            Boolean k = r1.login(Idu, Password);

            if (k == true) {
                System.out.println("logged!");
                break;
            }
            System.out.println("Wrong name or password.try again");
        }

        while (a) {
            System.out.println("-----------------////////////////////////////Admin you can do Following Things...--------------------");
            System.out.println("Enter 1 to See Movie LIst");
            System.out.println("Enter 2 to View All ");
            System.out.println("Enter 3 to Search Movie ");
            System.out.println("Enter 4 to Purchase movie ");
            System.out.println("Enter 5 to Rate movie ");
            System.out.println("Chooose: ");
            changer = window.nextInt();

            if (changer == 1) {

                while (b) {

                    SessionFactory sessionFactory = new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory();

                    Session session = sessionFactory.openSession();
                    session.beginTransaction();
                    List<Movie> movieList = movieEao.getMovies();
                    for (Movie m : movieList) {
                        ;
                        System.out.println(m.getMovieName() + "  -     price " + m.getPrice() + "  -    Category " + m.getGendre() + "  -     " + "movieid " + m.getMovieId());
                    }
                    session.getTransaction().commit();
                    session.close();
                    break;
                }
            }

            if (changer == 2) {
                System.out.println("Ennter Movie Id");
                Id = window.nextInt();
                System.out.println("--------");
                Gender = window.nextLine();
                while (a) {
                    Movie m = movieEao.viewSingleMovie(1);
                    System.out.println("Movie Name       - " + m.getMovieName());
                    System.out.println("Movie ID         - " + m.getMovieId());
                    System.out.println("Run Time         - " + m.getRuntime());
                    System.out.println("Release year     - " + m.getRelease_year());
                    System.out.println("Gendre           - " + m.getGendre());
                    System.out.println("Directorss       - " + m.getDirectorMovies());
                    System.out.println("Actors           - " + m.getActorMovie());
                    System.out.println("Reviews and Rate - " + movieEao.selectedReviews(1));

                    break;
                }

            }
            if (changer == 3) {
                while (b) {
                    
                    System.out.println(" Movie Name to search");
                    System.out.println("Enter Name ");
                    Name = window.nextLine();

                    List<Movie> movieList = movieEao.getSearch(Name);
                    for (Movie m : movieList) {
                        System.out.println(m.getMovieName());

                    }
                    break;
                }

            }
            if (changer == 4) {
                while (a) {

                    System.out.println("Enter Movie Id To Purchase");
                Id = window.nextInt();
                System.out.println("--------");
                Gender = window.nextLine();
                    SessionFactory sessionFactory;
                    sessionFactory = Hibernate.getSessionFactory();

                    Session session = sessionFactory.openSession();

                    session.beginTransaction();
                    Movie movie1 = (Movie) session.get(Movie.class, 1);
                    RegisteredUser user = (RegisteredUser) session.get(RegisteredUser.class, Idu);
                    Purchased p1 = new Purchased(movie1, user);
                    empEao.create(p1);

                    session.getTransaction().commit();
                    session.close();

                   }

            }
            if (changer == 5) {
                System.out.println("Movie id : ");
                Id = window.nextInt();
                System.out.println("------- ");
                Gendre = window.nextLine();
                System.out.println("V ");
                Gendre = window.nextLine();
                System.out.println("Movie Rating ");
                Age = window.nextInt();

                boolean r = rdEao.dosompare(1, Idu);
                if (c == true) {
                    rdEao.about(Age, Gendre, Id);

                }
            }

        }

 
        
        
        
      

        window.close();

        //----------------------------------------------------------------------
//     
//        movieEao.create(m3);
//        adEao.create(d2);
//        DirectorMovie dm2=new DirectorMovie(m2,d2);
//        m2.addDirectors(dm2);
//        adEao.make(m2);
//                
//        adEao.make(m1);
//        empEao.create(emp1);
//        Purchased b1=new Purchased(m3,emp1);
//        emp1.addPurch(b1);
//        empEao.buy(emp1);
//        
//        
//        Admin a2=new Admin("jjj","2324");
//        adEao.create(a2);
    }

}}
