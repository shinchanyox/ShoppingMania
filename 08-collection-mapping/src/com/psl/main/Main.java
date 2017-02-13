package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact c1 = new Contact("andre","bista","email1",Date.valueOf("2001-01-01")) ;
		Contact c2 = new Contact("shinchan","nohara","email2",Date.valueOf("1994-03-28")) ;
		c1.getMobileNumbers().add("12") ;
		c1.getMobileNumbers().add("34") ;
		c2.getMobileNumbers().add("98") ;
		c2.getMobileNumbers().add("76") ;
		
		c1.getAddresses().add(new Address("lola","li")) ;
		c1.getAddresses().add(new Address("pika","pi")) ;
		c2.getAddresses().add(new Address("bhopal","india")) ;
		c2.getAddresses().add(new Address("naka","gawa")) ;
		Configuration config = new Configuration().configure() ;
		SessionFactory sf = config.buildSessionFactory() ;
		Session session = sf.openSession() ;
		Transaction tx = session.beginTransaction() ;
		session.save(c1);
		session.save(c2);
		tx.commit() ;
		
		 tx = session.beginTransaction() ;
		session.delete(c1) ;
		tx.commit() ;
		session.close();
		sf.close() ;
	}

}
