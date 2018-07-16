package model;

public class User {
	private String name;
	private String lastname;
	private String username;
	private String password;

	private SystemModel system;
	
	public User() {
		super();
		name = null;
		lastname = null;
		username = null;
		password = null;
		system = null;
	}

	
	public void setUsername(String name) {
		username = name;
	}

	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	

	public String getName() {
		// TODO: implement
		return null;
	}

	
	public void setName(String name) {
		// todo
	}

	public String getLastname() {
		// TODO: implement
		return null;
	}

	public void setLastname(String lastname) {
		// TODO: implement
	}
}
