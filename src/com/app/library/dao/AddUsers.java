package com.app.library.dao;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.library.app.*;
import com.app.library.dto.Libusers;
import com.app.library.hbutil.Hibutil;
public class AddUsers {
	
	public  void adduser(Libusers libusers )
	{
		
		Transaction transaction= null;
		
		try(Session session =Hibutil.getSessionFactory().openSession()) {
			
			transaction= session.beginTransaction();
			session.save(libusers);
			
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction==null) {
				transaction.rollback();
			}
		}
	}
	
	
}
