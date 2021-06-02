package ua.itea.models;

import java.util.Map;

public class Cart {

	private Map<Product, Integer> products;

	public Cart() {
	}

	public Cart(Product product, Integer number) {
		products.put(product, number);
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	
	
	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}

}
