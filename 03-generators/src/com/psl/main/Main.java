package com.psl.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Contact;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact c1 = new Contact("andre","bista","email1",Date.valueOf("2001-01-01")) ;
		Contact c2 = new Contact("shinchan","nohara","email2",Date.valueOf("1994-03-28")) ;
		Configuration config = new Configuration().configure() ;
		SessionFactory sf = config.buildSessionFactory() ;
		Session session = sf.openSession() ;
		Transaction tx = session.beginTransaction() ;
		session.save(c1);
		session.save(c2);
		tx.commit() ;
		session.close();
		sf.close() ;
	}

}
