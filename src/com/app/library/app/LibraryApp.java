package com.app.library.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.library.dto.Libusers;

public class LibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libusers lusers=new Libusers();
		
		lusers.setUsername("Admin1");
		lusers.setPassword("1234");
		lusers.setUserRole("Admin");
		
		Libusers lusers2= new Libusers();
		
		lusers2.setUsername("Non Admin");
		lusers2.setPassword("1234");
		lusers2.setUserRole("LIBUSER");
				
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(lusers);
		session.save(lusers2);
		session.getTransaction().commit();
		session.close();
		
		lusers= null;
		session= sessionFactory.openSession();
		session.beginTransaction();
		
		//lusers=(Libusers) session.get(Libusers.class, 1);
		//System.out.println("UserName is : "+lusers.getUsername());
		//System.out.println("UserName is : "+lusers.getUserRole());
		System.out.println("Enter 1 for Admin : or 2 for LIBUser  or 3 for Exit");
		Scanner s=new Scanner(System.in);
		int temp=s.nextInt();
		List users= session.createQuery("FROM Libusers").list();
		switch(temp) {
		
		case 1 :
			
		//List users= session.createQuery("FROM Libusers").list();
		for(Iterator iterator =users.iterator(); iterator.hasNext();)
		{
			lusers=(Libusers) iterator.next();
			//System.out.println("UserID:"+ lusers.getUserid() +"UserName:" + lusers.getUsername() + "UserRole :" +lusers.getUserRole() );
			if(lusers.getUserRole().equals("Admin")) {
				System.out.println("Welcome to Admin Page:" +lusers.getUsername());
			}
			
		}
		break;
		
		case 2:
			for(Iterator iterator =users.iterator(); iterator.hasNext();)
			{
				lusers=(Libusers) iterator.next();
				//System.out.println("UserID:"+ lusers.getUserid() +"UserName:" + lusers.getUsername() + "UserRole :" +lusers.getUserRole() );
				if(lusers.getUserRole().equals("LIBUSER")) {
					System.out.println("Welcome to User Page:" +lusers.getUsername());
				}
			
			
		}
			break;
		
		default :
			System.exit(0);
			
		session.getTransaction().commit();
		session.close();
		
	}

}
}
