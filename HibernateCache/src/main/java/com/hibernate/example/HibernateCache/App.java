package com.hibernate.example.HibernateCache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Alien a = new Alien();

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Query q1 = session.createQuery("from Alien where id=101");
		q1.setCacheable(true);
		a = (Alien) q1.uniqueResult();

//        a=(Alien) session.get(Alien.class, 101);
		System.out.println(a);
		t.commit();
		session.close();

		Session session1 = sf.openSession();
		Transaction t1 = session1.beginTransaction();

		Query q2 = session1.createQuery("from Alien where id=101");
		q2.setCacheable(true);
		a = (Alien) q2.uniqueResult();

//        a=(Alien) session1.get(Alien.class, 101);
		System.out.println(a);
		t1.commit();
		session1.close();

	}
}
