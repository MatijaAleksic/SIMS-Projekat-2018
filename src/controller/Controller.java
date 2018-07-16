package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import enums.UserType;
import model.Administrator;
import model.Equipment;
import model.Ingredient;
import model.MealTag;
import model.RegisteredUser;
import model.SystemModel;
import model.User;
import view.MainWindow;

public class Controller {
	private SystemModel model;
	private MainWindow view;
	private static Controller controller = null;
	
	
	private Controller(SystemModel model, MainWindow view) {
		super();
		this.model = model;
		this.view = view;
		loadIngredients();
		loadEquipments();
		loadMealTags();
		loadUsers();
	}
	
	
	public static Controller getController(SystemModel model, MainWindow view) {
		if (controller == null)
			controller = new Controller(model, view);
		return controller;
	}
	
	
	public SystemModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}

	public UserType getCurrentUserType() {
		if (model.getCurrentUser() == null)
			return UserType.TEMPUSER;
		else if (model.getCurrentUser() instanceof model.RegisteredUser)
			return UserType.REGUSER;
		else 
			return UserType.ADMIN;
	}
	
	public void loadIngredients() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./resources/ingredients.txt"));
			String line = reader.readLine();
			while (line != null) {
				Ingredient ing = new Ingredient(line);
				model.addIngredient(ing);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadUsers()
	{
		String path = "." + System.getProperty("file.separator");
		String linija;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path + "resources/users.txt"));
			while ((linija = in.readLine()) != null)
			{
				String[] linije = linija.split("\\|");
			
				if(linije[0].equals("a"))
				{
					System.out.println("Proslo");
					Administrator a = new Administrator(linije[1], linije[2], linije[3], linije[4]);
					model.addUser(a);
				}
				else
				{
					RegisteredUser a = new RegisteredUser(linije[1], linije[2], linije[3], linije[4]);
					model.addUser(a);
				}
			}
			in.close();
		}
		catch (IOException e) {
			System.err.println("Greska!");
			e.printStackTrace();
		}
	}
	
	
	public void loadEquipments() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./resources/equipment.txt"));
			String line = reader.readLine();
			while (line != null) {
				Equipment eq = new Equipment(line);
				model.addEquipment(eq);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadMealTags() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./resources/mealTags.txt"));
			String line = reader.readLine();
			while (line != null) {
				MealTag mt = new MealTag(line);
				model.addMealTag(mt);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeUsers()
	{
		try
		{
			PrintWriter writer = new PrintWriter("./resources/users.txt", "UTF-8");
			ArrayList<User> usrs = model.listUsers();
			for(User u : usrs)
			{
				if(u instanceof Administrator)
				{
					writer.println("a|" + u.getName() + "|" + u.getLastname() + "|" + u.getUsername() + "|" + u.getPassword());
				}
				else
				{
					writer.println("u|" + u.getName() + "|" + u.getLastname() + "|" + u.getUsername() + "|" + u.getPassword());
				}
			}
			writer.close();		
		}
		catch(Exception e)
		{
			System.out.println("Greska pri upisu!");
		}
	}
}
