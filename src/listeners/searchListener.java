package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;
import view.SearchRecipesDialog;

public class searchListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		SearchRecipesDialog srd = new SearchRecipesDialog(MainWindow.getMainWindow());
		srd.setVisible(true);
	}

}
