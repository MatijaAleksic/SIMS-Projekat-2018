package model;

public class RecipeIngredient {
	private int amount;
	private boolean core;
	private Ingredient ingredient;

	public RecipeIngredient() {
		amount = 0;
		core = false;
		ingredient = null;
	}
	
	public RecipeIngredient(int amount, boolean core, Ingredient i) {
		this.amount = amount;
		this.core = core;
		ingredient = i;
	}

	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isCore() {
		return core;
	}

	public void setCore(boolean c) {
		core = c;
	}
	
	public void setIngredient(Ingredient i) {
		ingredient = i;
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}
}
