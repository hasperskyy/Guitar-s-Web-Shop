package ua.itea.DAO;

import java.sql.Connection;
import ua.itea.MySQL.MySQLFactoryDAO;

public abstract class FactoryDAO {

	public abstract UserDAO getUserDAO();
	public abstract ProductDAO getProductDAO();
	protected Connection connection;

	public FactoryDAO() {
	}

	public abstract Connection openConnection();

	public abstract void closeConnection();

	public static FactoryDAO getFactoryDAO(int type) {
		switch (type) {
		case 1:
			return new MySQLFactoryDAO();
		default:
			return null;
		}

	}

}
