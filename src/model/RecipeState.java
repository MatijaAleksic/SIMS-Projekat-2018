package model;

import enums.RecipeStateType;;

public abstract class RecipeState {
	private RecipeStateType type;
	private Recipe recipe;

	public RecipeStateType getType() {
		return type;
	}

	public abstract void recipeReported();
	public abstract void recipeDismissed();
	public abstract void setName(String n);
	public abstract void setDesc(String d);
	public abstract void setTime(int t);
	public abstract void setSteps(String s);
	public abstract void setVotes(int v);
}
