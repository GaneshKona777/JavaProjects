package com.hibernate.example.HibernateHQL1;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		// **************************************************************************//
		// 1- All Students Values from Student //

		// 2- from Student where marks > 50 //

		// 3- from Student where rollno=7 //

		// 6- select sum(marks) from Student s where s.marks>60 //
//		Query q = session.createQuery("select rollno,name,marks from Student s where s.marks>60	");

		// **************************************************************************//
		// 4- select rollno,name,marks from Student where rollno=7 //
//		Object[] stu=(Object[]) q.uniqueResult();
//		for(Object o:stu) {
//			System.out.println(o);
//		}
		// OR//
//		System.out.println(stu[0]+":"+stu[1]+":"+stu[2]);
		// **************************************************************************//
		// 5-select rollno,name,marks from Student //

//		List<Object[]> stud=q.list();
//		for(Object[] o:stud) {
//			System.out.println(o[0]+":"+o[1]+":"+o[2]);
//		}

		// **************************************************************************//
		// List of all students //
//        List<Student> studs=q.list();
//        for(Student s:studs)
//        {
//        	System.out.println(s);
//        }
		// END List of all students //

		// **************************************************************************//

		// *****single row**** //
//		Student studs = (Student) q.uniqueResult();
//		System.out.println(studs);
		// *****END single row**** //

		// **************************************************************************//

		// ** Creating a Table ** ///
//        Random r=new Random();
//        
//        for(int i=1;i<=50;i++)
//        {
//        	Student s=new Student();
//        	s.setRollno(i);
//        	s.setName("Name"+i);
//        	s.setMarks(r.nextInt(100));
//        	session.save(s);
//        }
		// **END Creating a Table ** ///

		// **************************************************************************//

		// @@@@@@@@@@@@ SQL Query in Hibrnate @@@@@@@@@@@@@//

		// 1- select * from Student where marks>60 //
//		SQLQuery q1=session.createSQLQuery("select * from Student where marks>60");
//		q1.addEntity(Student.class);
//		List<Student> li=q1.list();
//		for(Student s:li)
//		{
//			System.out.println(s);
//		}
		// 2- select name,marks from Student where marks>60 //
		SQLQuery q1 = session.createSQLQuery("select name,marks from Student where marks>60");
		q1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List li = q1.list();
		for (Object o : li) {
			Map m = (Map) o;
			System.out.println(m.get("name") + ":" + m.get("marks"));
		}

		// @@@@@@@@@@@@----------- END---------- SQL Query in Hibrnate @@@@@@@@@@@@@//

		t.commit();
		session.close();

	}
}
