package com.firstHibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg=new Configuration();    
		cfg.configure("hibernate.cfg.xml");    
		    
		//creating seession factory object    
		SessionFactory factory=cfg.buildSessionFactory();    
		    
		//creating session object    
		Session session=factory.openSession();    
		    
		//creating transaction object    
		Transaction t=session.beginTransaction();    
		
		Employee emp1=new Employee();
		
		emp1.setId(101);
		emp1.setFirstName("John");
		emp1.setLastName("Wesley");
		
		session.save(emp1);
		t.commit();
		session.close();
		

		
	}

}
