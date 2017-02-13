package com.psl.main;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.bean.Address;
import com.psl.bean.Contact;
import com.psl.bean.Profile;
import com.psl.bean.User;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u1 = new User("u1") ;
		User u2 = new User("u2") ;
		User u3 = new User("u3") ;
		User u4 = new User("u4") ;
		User u5 = new User("u5") ;
		
		Contact c1 = new Contact("andre","bista","email1",Date.valueOf("2001-01-01"),new Address("yo","man")) ;
		Contact c2 = new Contact("shinchan","nohara","email2",Date.valueOf("1994-03-28"),new Address("hima","mari")) ;
		Contact c3 = new Contact("a","bista","e",Date.valueOf("2001-01-01"),new Address("y","aman")) ;
		Contact c4 = new Contact("an","b","em",Date.valueOf("2002-01-01"),new Address("yo","bman")) ;
		Contact c5 = new Contact("and","bi","ema",Date.valueOf("2003-01-01"),new Address("ao","cman")) ;
		Contact c6 = new Contact("andr","bis","emai",Date.valueOf("2004-01-01"),new Address("byo","dman")) ;
		Contact c7 = new Contact("andre","bist","email",Date.valueOf("2005-01-01"),new Address("cyo","eman")) ;
		Contact c8 = new Contact("e","a","1",Date.valueOf("2006-01-01"),new Address("dyo","gman")) ;
		Contact c9 = new Contact("re","ta","l1",Date.valueOf("2007-01-01"),new Address("eyo","fman")) ;
		Contact c10 = new Contact("dre","sta","il1",Date.valueOf("2008-01-01"),new Address("fyo","hman")) ;
		
		u1.addContact(c1) ;
		u1.addContact(c2) ;
		
		u2.addContact(c3) ;
		u2.addContact(c4) ;
		
		u3.addContact(c5) ;
		u3.addContact(c6) ;
		
		u4.addContact(c7) ;
		u4.addContact(c8) ;
		
		u5.addContact(c9) ;
		u5.addContact(c10) ;
		
		Profile p1 = new Profile("s1","c1") ;
		Profile p2 = new Profile("s2","c2") ;
		Profile p3 = new Profile("s3","c3") ;
		Profile p4 = new Profile("s4","c4") ;
		Profile p5 = new Profile("s5","c5") ;
		Profile p6 = new Profile("s6","c6") ;
		Profile p7 = new Profile("s7","c7") ;
		Profile p8 = new Profile("s8","c8") ;
		Profile p9 = new Profile("s9","c9") ;
		Profile p10 = new Profile("s10","c10") ;
		
		c1.addProfile(p1) ;
		c1.addProfile(p2) ;
		c1.addProfile(p3) ;
		c1.addProfile(p4) ;
		c1.addProfile(p5) ;
		c1.addProfile(p6) ;
		c1.addProfile(p7) ;
		c1.addProfile(p8) ;
		c1.addProfile(p9) ;
		c1.addProfile(p10) ;
		                           		
		Configuration config = new Configuration().configure() ;
		SessionFactory sf = config.buildSessionFactory() ;
		Session session = sf.openSession() ;
		
		Transaction tx = session.beginTransaction() ;
		
		session.save(u1);
//		for(Contact c : u1.getContacts())
//			session.save(c) ;
		
		session.save(u2);
//		for(Contact c : u2.getContacts())
//			session.save(c) ;
		
		session.save(u3);
//		for(Contact c : u3.getContacts())
//			session.save(c) ;
		
		session.save(u4);
//		for(Contact c : u4.getContacts())
//			session.save(c) ;
		
		session.save(u5);
//		for(Contact c : u5.getContacts())
//			session.save(c) ;
		tx.commit() ;
		session.clear() ;
		
		User u = (User)session.get(User.class, new Integer(2)) ;
		//Set<Contact> c = session.get(Contact.class,u.getContacts()) ;
		//System.out.println(c.getFirstname());
		//u.getContacts().remove(c) ;
		
		session.close();
		sf.close() ;
	}

}
