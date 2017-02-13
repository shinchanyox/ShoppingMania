package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Employee;
import com.psl.bean.Friend;
import com.psl.bean.Relative;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Contact c1 = new Contact("andre","bista","email1",Date.valueOf("2001-01-01"),new Address("yo","man")) ;
//		Contact c2 = new Contact("shinchan","nohara","email2",Date.valueOf("1994-03-28"),new Address("hima","mari")) ;
		
		Contact c1 = new Employee("andre","bista","email1",Date.valueOf("2001-01-01"),new Address("yo","man"),"123","engineer") ;
		Contact c2 = new Friend("nohara","shin","email1",Date.valueOf("2001-01-01"),new Address("yo","man"),"pikachu") ;
		Contact c3 = new Relative("yo","man","email1",Date.valueOf("2001-01-01"),new Address("yo","man"),"bulbasaur") ;
		Configuration config = new Configuration().configure() ;
		SessionFactory sf = config.buildSessionFactory() ;
		Session session = sf.openSession() ;
		Transaction tx = session.beginTransaction() ;
		session.save(c1);
		session.save(c2);
		session.save(c3);
		tx.commit() ;
		
		session.clear() ;
		Relative c = (Relative)session.get(Relative.class,new Integer(3)) ;
		System.out.println(c.getFirstname()) ;
		
		
		session.close();
		sf.close() ;
	}

}
