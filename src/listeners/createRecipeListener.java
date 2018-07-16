package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import controller.Controller;
import model.Equipment;
import model.Ingredient;
import model.MealTag;
import model.Recipe;
import model.RecipeIngredient;
import model.RegisteredUser;
import view.CreateRecipeDialog;

public class createRecipeListener implements ActionListener {
	private CreateRecipeDialog dialog;
	Controller c = Controller.getController(null, null);
	
	public createRecipeListener(CreateRecipeDialog d) {
		super();
		dialog = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Finds selected ingredients, equipment, tags and add them to recipe 
		 * and sets info about recipe from text areas*/
		
		Recipe recipe = new Recipe();
	
		addIngredients(recipe, dialog.ingTable);
		addEquipment(recipe, dialog.eqsTable);
		addTags(recipe, dialog.tagsTable);
		setRecipeInfo(recipe, dialog);
		
		c.getModel().addRecipe(recipe);
		RegisteredUser currentUser = (RegisteredUser) c.getModel().getCurrentUser();
		currentUser.addRecipe(recipe);
		
		dialog.dispose();
	}
	
	
	public void setRecipeInfo(Recipe recipe, CreateRecipeDialog d) {
		recipe.setName(d.name.getText());
		recipe.setDesc(d.desc.getText());
		recipe.setSteps(d.steps.getText());
	}
	
	
	public void addIngredients(Recipe r, JTable ingTable) {
		for (int i = 0; i < c.getModel().getIngredients().size(); i++) {
			if ((boolean) ingTable.getValueAt(i, 0)) {
				Ingredient ing = findIngredient((String) ingTable.getValueAt(i, 1));
				RecipeIngredient ri = new RecipeIngredient(0, true, ing);
				r.addIngredient(ri);
			}
		}
	}
	
	
	public Ingredient findIngredient(String name) {
		for (Ingredient i : c.getModel().getIngredients()) {
			if (i.getName().equals(name))
				return i;
		}
		return null;
	}
	
	
	public void addEquipment(Recipe r, JTable eqsTable) {
		for (int i = 0; i < c.getModel().getEquipments().size(); i++) {
			if ((boolean) eqsTable.getValueAt(i, 0)) {
				Equipment eqs = findEquipment((String) eqsTable.getValueAt(i, 1));
				r.addEquipment(eqs);
			}
		}
	}
	
	
	public Equipment findEquipment(String name) {
		for (Equipment e : c.getModel().getEquipments()) 
			if (e.getName().equals(name))
				return e;
		return null;
	}
	
	
	
	public void addTags(Recipe r, JTable tagsTable) {
		for (int i = 0; i < c.getModel().getMealTags().size(); i++) {
			if ((boolean) tagsTable.getValueAt(i, 0)) {
				MealTag mt = findMealTag((String) tagsTable.getValueAt(i, 1));
				r.addMealTag(mt);
			}
		}
	}

	
	private MealTag findMealTag(String name) {
		for (MealTag mt : c.getModel().getMealTags()) 
			if (mt.getName().equals(name))
				return mt;
		return null;
	}
}
