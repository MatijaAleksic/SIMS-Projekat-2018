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

	public Recipe() {
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
	
	public void addIngredient(RecipeIngredient ri) {
		ingredients.add(ri);
	}
	
	public void addEquipment(Equipment e) {
		equipments.add(e);
	}
	
	public void addMealTag(MealTag mt) {
		mealTags.add(mt);
	}
	
	public boolean containsIng(Ingredient i) {
		for (RecipeIngredient ri : ingredients)
			if (i == ri.getIngredient())
				return true;
		return false;
	}
	
	public boolean containsEq(Equipment e) {
		if (equipments.contains(e))
			return true;
		return false;
	}
	
	public boolean containMt(MealTag mt) {
		if (mealTags.contains(mt))
			return true;
		return false;
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
		this.name = name;
	}

	public void setDesc(String desc) {
		// TODO: implement
		this.description = desc;
	}

	public void setTime(int t) {
		// TODO: implement
		this.cookingTime = t;
	}

	public void setSteps(String steps) {
		// TODO: implement
		this.steps = steps;
	}

	public void setVotes(int votes) {
		// TODO: implement
		this.votes = votes;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
}
