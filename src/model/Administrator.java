package model;

public class Administrator extends User {
	
	public Administrator() {
		super();
	}
	
	public Administrator(String name, String lastname, String username, String password) {
		super(name, lastname, username, password);
		// TODO Auto-generated constructor stub
	}

	public void approveRequest(Request req) {
		// TODO: implement
	}

	
	public void denyRequest(Request req) {
		// TODO: implement
	}

	
	public void approverReport(Recipe rec) {
		// TODO: implement
	}

	public void denyReport(Recipe rec) {
		// TODO: implement
	}
}
