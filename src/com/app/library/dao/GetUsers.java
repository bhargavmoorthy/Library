package com.app.library.dao;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.library.dto.Libusers;
import com.app.library.hbutil.Hibutil;

public class GetUsers {
	
public List<Libusers> getAllLibuser() {
		
		Transaction transaction= null;
		List<Libusers> libusers=null;
		
		try(Session session =Hibutil.getSessionFactory().openSession()) {
			
			  System.out.println("Enter 1 for Admin : or 2 for LIBUser  or 3 for Exit");
			  Scanner s=new Scanner(System.in); int temp=s.nextInt(); 
			transaction= session.beginTransaction();
			 libusers=session.createQuery("FROM Libusers").list();
			
			 switch(temp) {
			  
			  case 1 : 
			  { 
				  List<String> mappedUserRole = libusers.stream()
							.filter(result-> !"LIBUSER".equals(result.getUserRole())).map(Libusers::getUsername)
							.collect(Collectors.toList());
			 	System.out.println("Welcome to" +mappedUserRole+ "Page" );
					
						
			  }
			  break;
			  case 2:
			   {
				   
				   List<String> mappedUserRole1 = libusers.stream()
					.filter(result-> !"Admin".equals(result.getUserRole())).map(Libusers::getUsername)
					.collect(Collectors.toList());
				   System.out.println("Welcome to" +mappedUserRole1+ "Page" );
			   }
			  
			  break;
			  
			  default : System.exit(0);
			  
			  }
			 
						 
	transaction.commit();
	}
		catch (Exception e) {
			// TODO: handle exception
			if(transaction==null) {
				transaction.rollback();
			}
	
		}
	return libusers;

}
}
