package com.helper;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	public static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		
		if(factory==null) {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			
			// up till now we have just told the con obj to read the hibernate.cfg.xml(rules)
			
			factory = con.buildSessionFactory();
		}
		return factory;
	}
	
}
