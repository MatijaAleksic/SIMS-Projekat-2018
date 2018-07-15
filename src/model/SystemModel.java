package model;

import java.util.ArrayList;

public class SystemModel {
	private static SystemModel system = null;
	
	private int recipeMinVotes;
	private User currentUser;

	private ArrayList<Equipment> equipments;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<User> users;
	private ArrayList<Recipe> recipes;
	private ArrayList<MealTag> mealTags;
	private ArrayList<Recipe> reportedRecipes;
	private ArrayList<Request> requests;
	
	
	private SystemModel() {
		super();
		recipeMinVotes = 50;
		currentUser = null;
		equipments = new ArrayList<Equipment>();
		ingredients = new ArrayList<Ingredient>();
		users = new ArrayList<User>();
		recipes = new ArrayList<Recipe>();
		mealTags = new ArrayList<MealTag>();
		reportedRecipes = new ArrayList<Recipe>();
		requests = new ArrayList<Request>();
	}
	

	public static SystemModel getSystem() {
		if (system == null)
			system = new SystemModel();
		return system;
	}


	public void addRequest(Request req) {
		// TODO: implement
	}


	public void removeRequest(Request req) {
		// TODO: implement
	}

	public void addIngredient(Ingredient ing) {
		// TODO: implement
		ingredients.add(ing);
	}

	
	public void removeIngredient(Ingredient ing) {
		// TODO: implement
	}

	
	public void addUser(User user) {
		users.add(user);
	}

	
	public void removeUser(User user) {
	}

	
	public User findUser(String username) {
		for (User u : users) {
			System.out.println(u);
			System.out.println(username);
			if (u.getUsername().equals(username))
				return u;
		}
		return null;
	}

	
	public void addEquipment(Equipment eq) {
		// TODO: implement
		equipments.add(eq);
	}

	
	public void removeEquipment(Equipment eq) {
		// TODO: implement
	}

	
	public void addMealTag(MealTag tag) {
		// TODO: implement
		mealTags.add(tag);
	}

	
	public void removeMealTag(MealTag tag) {
		// TODO: implement
	}

	
	public void addRecipe(Recipe rec) {
		// TODO: implement
		recipes.add(rec);
	}

	
	public void removeRecipe(Recipe rec) {
		// TODO: implement
	}

	
	public ArrayList<Recipe> searchRecipes(ArrayList<Ingredient> ings, ArrayList<Equipment> eqs, ArrayList<MealTag> tags) {
		// TODO: implement
		return null;
	}

	
	public User loginCheck(String username, String password) {
		// TODO: implement
		for (User u : users) 
			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		return null;
	}

	
	public void checkRecipeVotes(Recipe rec) {
		// TODO: implement
	}

	
	public void reportRecipe(Recipe recipe) {
		// TODO: implement
	}
	
	
	public int getRecipeMatch(Recipe r, ArrayList<Ingredient> ings, ArrayList<Equipment> eqs, ArrayList<MealTag> tags) {
		// TODO: implement
		return 0;
	}


	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return currentUser;
	}
	
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}
	
	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	public ArrayList<Equipment> getEquipments() {
		return equipments;
	}

	
	public ArrayList<MealTag> getMealTags() {
		return mealTags;
	}
}
