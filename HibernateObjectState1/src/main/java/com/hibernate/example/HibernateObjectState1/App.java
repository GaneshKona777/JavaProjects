package com.hibernate.example.HibernateObjectState1;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Laptop l = new Laptop();
		l.setLid(53);
		l.setBrand("Apple");
		l.setPrice(800);
		session.save(l);
//		l.setPrice(650);

//         Random r=new Random();
//         for(int i=1;i<=50;i++)
//         {
//        	 Laptop l=new Laptop();
//        	 l.setLid(i);
//        	 l.setBrand("Name"+i);
//        	 l.setPrice(r.nextInt(1000));
//        	 session.save(l);
//         }
		
//		l=(Laptop) session.get(Laptop.class, 23);
//				System.out.println(l);
		t.commit();
//         session.save(l);
//         l.setPrice(500);
		session.close();
	}
}
