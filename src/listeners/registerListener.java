package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;
import view.RegisterDialog;

public class registerListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RegisterDialog d = new RegisterDialog(MainWindow.getMainWindow());
		d.setVisible(true);
	}

}
