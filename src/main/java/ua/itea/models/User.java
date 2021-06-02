package ua.itea.models;

import ua.itea.controllers.Utilites;

public class User {

	private String login;
	private String password;
	private String name;
	private String region;
	private int gender;
	private String comment;
	private boolean agree;

	public User() {
	}

	public User(String login, String password, String name, String region, int gender, String comment) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.region = region;
		this.gender = gender;
		this.comment = comment;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getRegion() {
		return region;
	}

	public int getGender() {
		return gender;
	}

	public String getComment() {
		return comment;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = Utilites.getHash(password);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

}
