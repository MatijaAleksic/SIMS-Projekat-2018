package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import listeners.createRecipeDialogListener;
import listeners.loginListener;
import listeners.logoutListener;
import listeners.myItemsListener;
import listeners.registerListener;
import listeners.searchByItemsListener;
import listeners.searchListener;
import enums.UserType;

public class ToolbarStandard extends JToolBar {
	private JButton search;
	private JButton searchByItems;
	private JButton myItems;
	private JButton createRecipe;
	private JButton login;
	private JButton logout;
	private JButton register;
	
	
	public ToolbarStandard(UserType type) {
		super();
		setFloatable(false);
		search = new JButton("Search");
		search.addActionListener(new searchListener());
		add(search);
		
		if (type == UserType.TEMPUSER)
			initTempUserToolbar();
		else if (type == UserType.REGUSER)
			initRegUserToolbar();
		else
			initAdminToolbar();
	}
	
	
	private void initTempUserToolbar() {
		register = new JButton("Register");
		register.addActionListener(new registerListener());
		add(register);
	
		login = new JButton("Login");
		login.addActionListener(new loginListener());
		add(login);
	}
	
	
	private void initRegUserToolbar() {
		searchByItems = new JButton("Search by items");
		searchByItems.addActionListener(new searchByItemsListener());
		add(searchByItems);
		
		createRecipe = new JButton("Create recipe");
		createRecipe.addActionListener(new createRecipeDialogListener());
		add(createRecipe);
		
		myItems = new JButton("My items");
		myItems.addActionListener(new myItemsListener());
		add(myItems);
		
		logout = new JButton("Logout");
		logout.addActionListener(new logoutListener());
		add(logout);
	}
	
	
	private void initAdminToolbar() {
		//TODO 
	}
}
