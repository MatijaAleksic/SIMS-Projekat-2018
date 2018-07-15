package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import model.User;
import view.LoginDialog;

public class loginCheckListener implements ActionListener {
	private LoginDialog dialog;
	
	public loginCheckListener(LoginDialog loginDialog) {
		// TODO Auto-generated constructor stub
		super();
		dialog = loginDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String username = dialog.getUsername();
		String password = dialog.getPassword();
		Controller c = Controller.getController(null, null);
		User user;
		if ((user = c.getModel().loginCheck(username, password)) != null) {
			c.getModel().setCurrentUser(user);
			c.getView().setNewToolbar(c.getCurrentUserType());
			dialog.dispose();
		}

	}

}
