package ua.itea.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ua.itea.DAO.UserDAO;
import ua.itea.controllers.Utilites;
import ua.itea.models.User;

public class MySQLUserDAO implements UserDAO {

	User user;

	private static final String UNIQUE_QUERY = "Select * FROM USERS WHERE login = ?";

	private static final String SELECT_QUERY = "Select * FROM USERS WHERE login = ? && password = ?";

	private static final String INSERT_QUERY = "INSERT INTO USERS (login, password, name, region, gender, comment) "
			+ "VALUES (?,?,?,?,?,?)";

	private static final String UPDATE_QUERY = "UPDATE USERS SET login=?, password=?, name=?, region=?,"
			+ "gender=?, comment=? WHERE login=?";

	@Override
	public boolean isUnique(String login) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
			System.out.println("Connection Success");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		ResultSet rs = null;
		PreparedStatement ps = null;
		boolean isUnique = true;

		try {
			ps = conn.prepareStatement(UNIQUE_QUERY);
			ps.setString(1, login);

			rs = ps.executeQuery();

			if (rs.next()) {
				isUnique = false;
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

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException sqlEx) {
				}

				ps = null;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUnique;
	}

	@Override
	public User getAuth(String login, String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
			System.out.println("Connection Success");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(SELECT_QUERY);
			ps.setString(1, login);
			ps.setString(2, Utilites.getHash(password));

			rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();
				System.out.println("Login: " + rs.getString("Login"));
				user.setLogin(rs.getString("Login"));
				System.out.println("Password: " + rs.getString("Password"));
				user.setPassword(rs.getString("Password"));
				System.out.println("Name: " + rs.getString("Name"));
				user.setName(rs.getString("Name"));
				System.out.println("Region: " + rs.getString("Region"));
				user.setRegion(rs.getString("Region"));
				System.out.println("Gender: " + rs.getInt("Gender"));
				user.setGender(rs.getInt("Gender"));
				System.out.println("Comment: " + rs.getString("Comment"));
				user.setComment(rs.getString("Comment"));
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

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException sqlEx) {
				}

				ps = null;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	@Override
	public void insertUser(String login, String password, String name, String region, int gender, String comment) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
			System.out.println("Connection Success");

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(INSERT_QUERY);
			ps.setString(1, login);
			ps.setString(2, Utilites.getHash(password));
			ps.setString(3, name);
			ps.setString(4, region);
			ps.setInt(5, gender);
			ps.setString(6, comment);
			ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException sqlEx) {
				}

				ps = null;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void updateUser(String login, String password, String name, String region, int gender, String comment) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/iteashop?" + "user=root&password=");
			System.out.println("Connection Success");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(UPDATE_QUERY);
			ps.setString(1, login);
			ps.setString(2, Utilites.getHash(password));
			ps.setString(3, name);
			ps.setString(4, region);
			ps.setInt(5, gender);
			ps.setString(6, comment);
			ps.setString(7, login);
			ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException sqlEx) {
				}

				ps = null;
			}

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
