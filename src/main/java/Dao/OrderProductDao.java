package Dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Cart_Items;
import com.entities.Order;
import com.entities.Order_Product;
import com.entities.User;
import com.helper.FactoryProvider;

public class OrderProductDao {
	public static boolean AddToOrderProductTable(User user, Order order, String address,Session si) {

		try {
			Session ss = FactoryProvider.getFactory().openSession();
			

			List<Cart_Items> Cart_Items_List = CartDao.DisplayCartItemsint(user);
			Random rand = new Random();

			for (int i = 0; i < Cart_Items_List.size(); i++) {
				Transaction tx = ss.beginTransaction();
				int days = rand.nextInt(6) + 3;
				Order_Product object = new Order_Product(order, Cart_Items_List.get(i).getProduct(), address,
						Cart_Items_List.get(i).getProduct().getCost(), days);

				// creating a object of order
				ss.persist(object);
				tx.commit();

			}
			
			System.out.println("2st error");

			ss.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}
}
