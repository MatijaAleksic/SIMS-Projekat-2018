package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import model.RegisteredUser;
import view.RegisterDialog;

public class registerCheckListener implements ActionListener {
	private RegisterDialog dialog;
	
	
	public registerCheckListener(RegisterDialog d) {
		super();
		dialog = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Controller c = Controller.getController(null, null);
		
		String username = dialog.getUsername();
		String password = dialog.getPassword();
		
		if (c.getModel().findUser(username) == null) {
			RegisteredUser user = new RegisteredUser();
			user.setUsername(username);
			user.setPassword(password);
			c.getModel().addUser(user);
			dialog.dispose();
		} else {
			System.out.println("User already exists!");
		}
			
		
	}

}
