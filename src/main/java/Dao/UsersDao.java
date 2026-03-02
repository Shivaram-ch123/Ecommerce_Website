package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.*;
import com.helper.FactoryProvider;



public class UsersDao {
	//here we will fetch the data from the db 
	//and then we can insert delete ,... in to the db
	public static boolean InsertIntoDatabase(String name ,String Phone,Cart cart) throws Exception{
		
		try {
			SessionFactory factory=FactoryProvider.getFactory();
			
			Session session = factory.openSession();
	
			
			Transaction t = session.beginTransaction();
			
			// creating the rows that i need to inser

			User user1 = new User(name,Phone,cart);
			session.persist(user1);
			
			t.commit();
			
			session.close();
			
			
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public static User CheckExistance(String name,String phone) {
		try {
			SessionFactory factory = FactoryProvider.getFactory();
			Session session = factory.openSession();

			Query<User> query = session.createQuery(
				    "FROM User u WHERE u.name = :name AND u.phonenumber = :phone", User.class);
			
			query.setParameter("name", name);
			query.setParameter("phone", phone);
			
			User user = query.uniqueResult();
			session.close();
			
			if(user!=null) {
				return user;
			}

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
}
