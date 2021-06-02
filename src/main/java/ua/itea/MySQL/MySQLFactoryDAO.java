package ua.itea.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ua.itea.DAO.FactoryDAO;
import ua.itea.DAO.ProductDAO;
import ua.itea.DAO.UserDAO;

public class MySQLFactoryDAO extends FactoryDAO {

	@Override
	public ProductDAO getProductDAO() {
		return new MySQLProductDAO();
	}

	
	@Override
	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}
	
	@Override
	public Connection openConnection() {
		
		connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
			System.out.println("Get Connection");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return connection;
	}

	@Override
	public void closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
