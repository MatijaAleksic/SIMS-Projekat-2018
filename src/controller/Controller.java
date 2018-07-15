package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import enums.UserType;
import model.Equipment;
import model.Ingredient;
import model.MealTag;
import model.SystemModel;
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
	
}
