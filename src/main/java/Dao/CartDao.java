 package Dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Cart;
import com.entities.Cart_Items;
import com.entities.Product;
import com.entities.User;
import com.helper.FactoryProvider;

public class CartDao {
	public static boolean AddProducttoCart(int userId,int productId) {
		//first i need to get the cart id 
		//then add the product ids to the corresponding userid
		
		try {
			int cartId = -1;
			Session s = FactoryProvider.getFactory().openSession();
			
			
			User user = s.get(User.class,userId);
			 cartId = user.getCart().getCartId();
			 Cart cart = s.get(Cart.class, cartId);
			
			Product product = s.get(Product.class, productId);
			

			
			
			Cart_Items item = new Cart_Items(cart,product,1);

			
			
			
			Transaction transaction = s.beginTransaction();
			
			Cart_Items result = s.createQuery(
				    "FROM Cart_Items ci WHERE ci.cart.cartId = :cartId AND ci.product.productId = :productId", 
				    Cart_Items.class)
				    .setParameter("cartId", cartId)
				    .setParameter("productId", productId)
				    .uniqueResult(); // hql
			
			if(result!=null) {
				String hql = "UPDATE Cart_Items ci SET ci.count = :newCount " +
			             "WHERE ci.cart.cartId = :cartId AND ci.product.productId = :productId";
				//to update the count
				int newCount = result.getCount()+1;
				result.setCount(newCount); // increment
			    // s.update(result);  here the hibernate will auto update u dont need to use any method
				
				
				
			}else s.persist(item);
			
			
			
			transaction.commit();
			s.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
	
				
	}
	
	public static List<Cart_Items>  DisplayCartItemsint(User user) {
		//get the factory 
		try {
			Session session =  FactoryProvider.getFactory().openSession();
			
			//iam fetching the data right so i dont need the transaction here
			
			
			
			//Note : here while working with `he data base 
			/*
			    getResultList() → for multiple results
				getSingleResult() → for one result
				executeUpdate() → for UPDATE / DELETE
			 */
			int cartId = user.getCart().getCartId();
			List<Cart_Items> answer = session.createQuery("FROM Cart_Items AS c WHERE c.cart.cartId = :cartId", Cart_Items.class)
			.setParameter("cartId",cartId)
			.getResultList();
			System.out.println(answer);
			

			
			return answer;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
		
	}
}
