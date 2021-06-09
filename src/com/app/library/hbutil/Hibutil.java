package com.app.library.hbutil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.app.library.dto.Libusers;

public class Hibutil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				Configuration configuration= new Configuration();
				Properties setting = new Properties();
				setting.put(Environment.DRIVER,"org.postgresql.Driver");
				setting.put(Environment.URL,"jdbc:postgresql://localhost:5432/Library");
				setting.put(Environment.USER,"postgres");
				setting.put(Environment.PASS,"Bhanu@520");
				setting.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
				setting.put(Environment.SHOW_SQL,"true");
				setting.put(Environment.HBM2DDL_AUTO, "create");
				
				configuration.setProperties(setting);
				configuration.addAnnotatedClass(Libusers.class);
				
				ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory =configuration.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}return sessionFactory;
	}

}
