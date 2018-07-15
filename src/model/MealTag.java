package model;

public class MealTag {
	private String name;
	
	public MealTag() {
		name = null;
	}
	
	public MealTag(String s) {
		name = s;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
