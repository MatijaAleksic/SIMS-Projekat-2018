package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.registerCheckListener;

public class RegisterDialog extends JDialog {
	private JLabel username, password;
	private JTextField userField, passField;
	private JButton okButton;
	
	
	public RegisterDialog(JFrame mainWindow) {
		super(mainWindow);
		initGui();
	}
	
	private void initGui() {
		setTitle("Registration");
		setSize(300, 150);
		super.setLocationRelativeTo(null);
		
		username = new JLabel("Username: ");
		password = new JLabel("Password:" );
		userField = new JTextField(15);
		passField = new JTextField(16);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new registerCheckListener(this));
		
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel bot = new JPanel(new FlowLayout(FlowLayout.CENTER));
		top.add(username);
		top.add(userField);
		mid.add(password);
		mid.add(passField);
		bot.add(okButton);
		
		add(top, BorderLayout.NORTH);
		add(mid, BorderLayout.CENTER);
		add(bot, BorderLayout.SOUTH);
	}
	
	public String getUsername() {
		return userField.getText();
	}
	
	public String getPassword() {
		return passField.getText();
	}
}
