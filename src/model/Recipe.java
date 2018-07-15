package model;

import java.util.ArrayList;
import enums.RecipeStateType;

public class Recipe {
	private String name;
	private String description;
	private int cookingTime;
	private String steps;
	private int votes;

	private ArrayList<Equipment> equipments;
	private ArrayList<Comment> comments;
	private ArrayList<RecipeIngredient> ingredients;
	private ArrayList<MealTag> mealTags;
	private ArrayList<RecipeState> recipeStates;
	private RecipeState currentState;
	private RegisteredUser author;

	Recipe() {
		super();
		name = null;
		description = null;
		cookingTime = 0;
		steps = null;
		votes = 0;
		equipments = new ArrayList<Equipment>();
		comments = new ArrayList<Comment>();
		ingredients = new ArrayList<RecipeIngredient>();
		mealTags = new ArrayList<MealTag>();
		recipeStates = new ArrayList<RecipeState>();
		currentState = null;
		author = null;
	}

	public void addComment(Comment c) {
		// TODO: implement
	}

	public void removeComment(Comment c) {
		// TODO: implement
	}

	public void recipeReported() {
		// TODO: implement
	}

	public void reportDismissed() {
		// TODO: implement
	}

	public void setState(RecipeStateType s) {
		// TODO: implement
	}

	public void setName(String name) {
		// TODO: implement
	}

	public void setDesc(String desc) {
		// TODO: implement
	}

	public void setTime(int t) {
		// TODO: implement
	}

	public void setSteps(String steps) {
		// TODO: implement
	}

	public void setVotes(int votes) {
		// TODO: implement
	}
}
