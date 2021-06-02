package ua.itea.controllers;

import java.util.Comparator;

import ua.itea.models.Product;

public class ProductCompareByName implements Comparator <Product>{

	@Override
	public int compare(Product product_1, Product product_2) {
			return product_1.getName().compareTo(product_2.getName());
	}

}
