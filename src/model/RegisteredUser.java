package model;

import java.util.ArrayList;

public class RegisteredUser extends User {
	private int votes;
	
	private ArrayList<Recipe> recipes;
	private ArrayList<Comment> comments;
	private ArrayList<UserIngredient> ingredients;
	private ArrayList<Equipment> equipments;

	public RegisteredUser() {
		super();
		votes = 0;
		recipes = new ArrayList<Recipe>();
		comments = new ArrayList<Comment>();
		ingredients = new ArrayList<UserIngredient>();
		equipments = new ArrayList<Equipment>();
	}
	
	
	public RegisteredUser(String name, String lastname, String username, String password) {
		super(name, lastname, username, password);
		// TODO Auto-generated constructor stub
		votes = 0;
		recipes = new ArrayList<Recipe>();
		comments = new ArrayList<Comment>();
		ingredients = new ArrayList<UserIngredient>();
		equipments = new ArrayList<Equipment>();	
	}
	
	
	public void addIngredient(Ingredient ing) {
		// TODO: implement
	}

	
	public void removeIngredient(Ingredient ing) {
		// TODO: implement
	}

	
	public void addEquipment(Equipment eq) {
		// TODO: implement
	}

	
	public void removeEquipment(Equipment eq) {
		// TODO: implement
	}

	
	public void addRecipe(Recipe rec) {
		// TODO: implement
		recipes.add(rec);
	}

	
	public void removeRecipe(Recipe rec) {
		// TODO: implement
	}

	public ArrayList<Recipe> searchByItems() {
		// TODO: implement
		return null;
	}
}
