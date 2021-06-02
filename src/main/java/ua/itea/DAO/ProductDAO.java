package ua.itea.DAO;

import java.util.TreeSet;
import ua.itea.models.Product;

public interface ProductDAO {
	
	public TreeSet<Product> getProductList();
	public TreeSet<Product> getProductbyCategory(int category);
	public Product getProductById(int id);
}
