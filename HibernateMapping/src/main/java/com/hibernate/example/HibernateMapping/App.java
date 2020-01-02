package com.hibernate.example.HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop lap=new Laptop();
        lap.setLid(101);
        lap.setLname("Dell");
         
        
        Student stud=new Student();
        stud.setRollno(1);
        stud.setSname("Tom");
        stud.setMarks(85);
        stud.getLaptop().add(lap);
        
        
        lap.getStudent().add(stud);
        
        Configuration  con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        con.configure("hibernate.cfg.xml");
        
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        
        Transaction t=session.beginTransaction();
        session.save(lap);
        session.save(stud);
        t.commit();
        session.close();
    }
}
