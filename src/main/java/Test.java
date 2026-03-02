import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Product;
import com.helper.FactoryProvider;

public class Test {
	public static void main(String args[]) {
		
		List<String> productImageUrls = Arrays.asList(
			    "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9",
			    "https://images.unsplash.com/photo-1512499617640-c2f9992ad3e5",
			    "https://images.unsplash.com/photo-1503602642458-232111445657",
			    "https://images.unsplash.com/photo-1511367461989-f85a21fda167",
			    "https://images.unsplash.com/photo-1580894747368-42e9d5062346",
			    "https://images.unsplash.com/photo-1573496780867-501cc88ab8ea",
			    "https://images.unsplash.com/photo-1519744792095-2f2205e87b6f",
			    "https://images.unsplash.com/photo-1542291026-7eec264c27ff",
			    "https://images.unsplash.com/photo-1528701800489-20e1247dfb40",
			    "https://images.unsplash.com/photo-1517336714731-489689fd1ca8",
			    "https://images.unsplash.com/photo-1537498425277-c283d32ef9db",
			    "https://images.unsplash.com/photo-1555617117-08ee7d8f3fb0",
			    "https://images.unsplash.com/photo-1587202372775-0ae875fa087c",
			    "https://images.unsplash.com/photo-1583243162381-aae16620685d",
			    "https://images.unsplash.com/photo-1587496679747-4bc1dfcc798e",
			    "https://images.unsplash.com/photo-1519183071298-a2962beade83",
			    "https://images.unsplash.com/photo-1495433324511-bf8e92934d90",
			    "https://images.unsplash.com/photo-1534003295913-94b898db8d51",
			    "https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f",
			    "https://images.unsplash.com/photo-1556742400-b5c3b4e59b43"
			);
		Session s = FactoryProvider.getFactory().openSession();

		Transaction tx = s.beginTransaction();

		for (int i = 0; i < 20; i++) {
			Product product = new Product("Redmi S" + i, (9000 + (i * 2000)),productImageUrls.get(i));
			s.persist(product);
		}

		tx.commit();

		s.close();
	}
}
