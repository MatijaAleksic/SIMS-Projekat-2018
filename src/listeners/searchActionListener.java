package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Controller;
import model.Equipment;
import model.Ingredient;
import model.MealTag;
import model.Result;
import view.MainWindow;
import view.SearchRecipesDialog;

public class searchActionListener implements ActionListener {
	
	private SearchRecipesDialog dialog;
	private Controller c = Controller.getController(null, null);
	
	public searchActionListener(SearchRecipesDialog d) {
		super();
		dialog = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		ArrayList<Ingredient> ings = new ArrayList<Ingredient>();
		ArrayList<Equipment> eqs = new ArrayList<Equipment>();
		ArrayList<MealTag> mts = new ArrayList<MealTag>();
		
		fillParameterLists(ings, eqs, mts);
		
		ArrayList<Result> results = c.getModel().searchRecipes(ings, eqs, mts);
		
		if (results.size() > 0) {
			MainWindow.getMainWindow().initTable(results);
			dialog.dispose();
		} else {
			JOptionPane.showMessageDialog(dialog, "No results!");
		}
		
		
	}
	
	public void fillParameterLists(ArrayList<Ingredient> ings, ArrayList<Equipment> eqs, ArrayList<MealTag> mts) {
		Ingredient ing;
		for (int i = 0; i < c.getModel().getIngredients().size(); i++) 
			if ((boolean) dialog.ingTable.getValueAt(i, 0)) {
				ing = findIngredient((String) dialog.ingTable.getValueAt(i, 1));
				ings.add(ing);
			}
		
		
		Equipment eq;
		for (int i = 0; i < c.getModel().getEquipments().size(); i++)
			if ((boolean) dialog.eqTable.getValueAt(i, 0)) {
				eq = findEquipment((String) dialog.eqTable.getValueAt(i, 1));
				eqs.add(eq);
			}
		
		
		MealTag mt;
		for (int i = 0; i < c.getModel().getMealTags().size(); i++)
			if ((boolean) dialog.tagTable.getValueAt(i, 0)) {
				mt = findMealTag((String) dialog.tagTable.getValueAt(i, 1));
				mts.add(mt);
			}
	}
	
	
	public Ingredient findIngredient(String name) {
		for (Ingredient i : c.getModel().getIngredients()) {
			if (i.getName().equals(name))
				return i;
		}
		return null;
	}
	
	
	public Equipment findEquipment(String name) {
		for (Equipment e : c.getModel().getEquipments()) 
			if (e.getName().equals(name))
				return e;
		return null;
	}
	
	
	private MealTag findMealTag(String name) {
		for (MealTag mt : c.getModel().getMealTags()) 
			if (mt.getName().equals(name))
				return mt;
		return null;
	}
}
