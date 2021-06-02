package ua.itea.controllers;

import java.util.Comparator;

import ua.itea.models.Product;

public class ProductCompareByPrice implements Comparator<Product> {

	@Override
	public int compare(Product product_1, Product product_2) {

		if (product_1.getPrice() > product_2.getPrice())
			return 1;
		else if (product_1.getPrice() < product_2.getPrice())
			return -1;
		else
			return 0;
	}

}
