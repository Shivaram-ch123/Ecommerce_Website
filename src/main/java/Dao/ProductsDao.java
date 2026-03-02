package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Product;
import com.helper.FactoryProvider;

public class ProductsDao {
	public static boolean InsertIntoProducts(Product object) {
		try {
			Session s = FactoryProvider.getFactory().openSession();
			
			Transaction tx = s.beginTransaction();
			
			s.persist(object);
			
			
			
			
			
			tx.commit();
			
			s.close();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}
}
