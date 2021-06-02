package ua.itea.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.TreeSet;

import ua.itea.DAO.ProductDAO;
import ua.itea.controllers.ProductCompareByName;
import ua.itea.controllers.ProductCompareByPrice;
import ua.itea.models.Product;

public class MySQLProductDAO implements ProductDAO {

	private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * from products WHERE id = ?";

	private static final String GET_PRODUCT_BY_CATEGORY_QUERY = "SELECT * FROM products WHERE category = ?";

	private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";

	MySQLFactoryDAO dao = new MySQLFactoryDAO();

	@Override
	public Product getProductById(int id) {

		Connection connection = dao.openConnection();

		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			preStmt = connection.prepareStatement(GET_PRODUCT_BY_ID_QUERY);
			preStmt.setInt(1, id);
			rs = preStmt.executeQuery();
			Product product;

			if (rs.next()) {

				product = new Product();
				product.setId(rs.getInt("id"));
				System.out.println(product.getId());
				product.setName(rs.getString("name"));
				System.out.println(product.getName());
				product.setCategory(rs.getInt("category"));
				System.out.println(product.getCategory());
				product.setPrice(rs.getInt("price"));
				System.out.println(product.getPrice());
				product.setDescription(rs.getString("description"));
				System.out.println(product.getDescription());
				return product;
			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}

				rs = null;
			}

			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException sqlEx) {
				}

				preStmt = null;
			}

			dao.closeConnection();
		}

		return null;
	}

	@Override
	public TreeSet<Product> getProductList() {

		Comparator<Product> productCompare = new ProductCompareByPrice().thenComparing(new ProductCompareByName());
		TreeSet<Product> productSet = new TreeSet<Product>(productCompare);

		Connection connection = dao.openConnection();

		Statement Stmt = null;
		ResultSet rs = null;

		try {
			Stmt = connection.createStatement();
			rs = Stmt.executeQuery(GET_ALL_PRODUCTS_QUERY);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				System.out.println(product.getId());
				product.setName(rs.getString("name"));
				System.out.println(product.getName());
				product.setCategory(rs.getInt("category"));
				System.out.println(product.getCategory());
				product.setPrice(rs.getInt("price"));
				System.out.println(product.getPrice());
				product.setDescription(rs.getString("description"));
				System.out.println(product.getDescription());
				productSet.add(product);

			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}

				rs = null;
			}

			if (Stmt != null) {
				try {
					Stmt.close();
				} catch (SQLException sqlEx) {
				}

				Stmt = null;
			}

			dao.closeConnection();
		}

		return productSet;
	}

	@Override
	public TreeSet<Product> getProductbyCategory(int category) {

		Comparator<Product> compareProduct = new ProductCompareByPrice().thenComparing(new ProductCompareByName());
		TreeSet<Product> productSet = new TreeSet<Product>(compareProduct);

		Connection connection = dao.openConnection();

		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			preStmt = connection.prepareStatement(GET_PRODUCT_BY_CATEGORY_QUERY);
			preStmt.setInt(1, category);
			rs = preStmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				System.out.println(product.getId());
				product.setName(rs.getString("name"));
				System.out.println(product.getName());
				product.setCategory(rs.getInt("category"));
				System.out.println(product.getCategory());
				product.setPrice(rs.getInt("price"));
				System.out.println(product.getPrice());
				product.setDescription(rs.getString("description"));
				System.out.println(product.getDescription());
				productSet.add(product);
			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}

				rs = null;
			}

			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException sqlEx) {
				}

				preStmt = null;
			}

			dao.closeConnection();
		}

		return productSet;
	}

}
