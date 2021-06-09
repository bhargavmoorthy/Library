package com.app.library.app;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.library.dao.AddUsers;
import com.app.library.dao.GetUsers;
import com.app.library.dto.Libusers;
import com.app.library.hbutil.Hibutil;

public class LibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddUsers adduser1 = new AddUsers();
		Libusers lusers =new Libusers(1,"Admin1","1234","Admin");
		Libusers lusers1 =new Libusers(2,"LIBUSER1","1234","LIBUSER");
		adduser1.adduser(lusers);
		adduser1.adduser(lusers1);
		System.out.println("UserName is : "+lusers.getUsername());
		GetUsers getUsers= new GetUsers();
		getUsers.getAllLibuser();

		 
		 
	}

}
