package ua.itea.DAO;

import ua.itea.models.User;

public interface UserDAO {

	public User getAuth(String login, String password);
	public boolean isUnique (String login);
	public void insertUser(String login, String password, String name, String region, int gender, String comment);
	public void updateUser(String login, String password, String name, String region, int gender, String comment);

}
