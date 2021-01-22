package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class Application {

    //QUES-1
    public static void Save_Alien_Object()
    {
        Alien a = new Alien("Sanchit","Blue");

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(a);
        tx.commit();
    }

    //QUES-2
    public static void Retrieve_Alien_Object()
    {
        Alien alienObj;

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        alienObj =(Alien)session.get(Alien.class,1);
        System.out.println(alienObj);
        tx.commit();
    }

    //Ques3
    public static void First_Level_Cache()
    {
        Alien alienObj;

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        alienObj = (Alien) session.get(Alien.class,1);
        //System.out.println(alienObj);
        //tx.commit();

        alienObj = (Alien)session.get(Alien.class,1);
        //System.out.println(alienObj);
        tx.commit();
    }
    public static void Second_Level_Cache()
    {
        Alien alienObj;

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        alienObj = session.get(Alien.class,1);
        System.out.println(alienObj);
        tx.commit();

        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        alienObj = session.get(Alien.class,1);
        System.out.println(alienObj);
        tx1.commit();
    }

    //QUES-5 and 6
    public static void HQL_Query()
    {
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();

        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = 1");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();

        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = 1");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        tx2.commit();
    }

    public static void main(String [] args) {

        //Ques-1
        Save_Alien_Object();

        //Ques-2
        Retrieve_Alien_Object();

        //Ques-3
        First_Level_Cache();

        //Ques-4
        Second_Level_Cache();

        //Ques-5,6
        HQL_Query();
    }

}
