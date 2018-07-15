package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginDialog;
import view.MainWindow;

public class loginListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		LoginDialog dialog = new LoginDialog(MainWindow.getMainWindow());
		dialog.setVisible(true);
	}

}
