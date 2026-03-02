package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Order;
import com.entities.User;
import com.helper.FactoryProvider;

public class OrderDao {
	public static boolean AddToOrdersTable(User user,Order o) {

		try {
			Session s = FactoryProvider.getFactory().openSession();

			Transaction tx = s.beginTransaction();
			
			
			//creating a object of order
			
			
			
			
			
			

			tx.commit();

			s.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

	}
	
	public static Order GetTheOrderObject(User user) {
		Session s = FactoryProvider.getFactory().openSession();
		Order order = s.createQuery(
		        "FROM Order o WHERE o.userId = :user", Order.class)
		        .setParameter("user", user)
		        .uniqueResult();
		
		return order;
	}
}

