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
	
	public User(String name, String lastname, String username, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		system = null;
	}

	
	public void setUsername(String name) {
		username = name;
	}

	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
	

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
