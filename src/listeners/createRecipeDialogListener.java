package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CreateRecipeDialog;
import view.MainWindow;

public class createRecipeDialogListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CreateRecipeDialog d = new CreateRecipeDialog(MainWindow.getMainWindow());
		d.setVisible(true);
	}

}
