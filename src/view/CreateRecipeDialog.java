package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Equipment;
import model.Ingredient;
import model.MealTag;

public class CreateRecipeDialog extends JDialog {
	
	private JTabbedPane pane;
	private JPanel descPanel, ingPanel, eqsPanel, tagsPanel;
	
	private JTextArea name, desc, steps;
	
	private JTable ingTable, eqsTable, tagsTable;
	
	public CreateRecipeDialog(JFrame mainWin) {
		super(mainWin);
		initGui();
	}
	
	public void initGui() {
		setSize(360, 400);
		
		pane = new JTabbedPane();
		
		initDescPanel();
		initIngPanel();
		initEquipPanel();
		initTagsPanel();
		
		pane.add("Description", descPanel);
		pane.add("Ingredients", ingPanel);
		pane.add("Equipments", eqsPanel);
		pane.add("Meal tags", tagsPanel);
	
		add(pane);
		
	}
	
	private void initDescPanel() {
		descPanel = new JPanel();
		descPanel.setLayout(new BoxLayout(descPanel, BoxLayout.PAGE_AXIS));
		
		descPanel.add(new JLabel("Recipe name:"));
		name = new JTextArea("", 1, 20);
		name.setLineWrap(true);
		descPanel.add(name);
		
		descPanel.add(new JLabel("Description:"));
		desc = new JTextArea("", 5, 25);
		desc.setLineWrap(true);
		descPanel.add(desc);
		
		descPanel.add(new JLabel("Steps:"));
		steps = new JTextArea("", 6, 20);
		steps.setLineWrap(true);
		descPanel.add(steps);
		
		
		descPanel.add(new JButton("OK"));
	}
	
	private void initIngPanel() {
		ingPanel = new JPanel();
		
		Controller c = Controller.getController(null, null);
		ArrayList<Ingredient> ings = c.getModel().getIngredients();
		
		String[] cols = {"Select", "Name", "Amount"};
		Object[][] values = new Object[ings.size()][3];
		
		for (int i = 0; i < ings.size(); i++) {
			values[i][0] = false;
			values[i][1] = ings.get(i).getName();
			values[i][2] = "";
		}
		
		DefaultTableModel dtm = new DefaultTableModel(values, cols);
		ingTable = new JTable(dtm){
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
			}
		};
		
		JScrollPane scrollPane = new JScrollPane(ingTable);
		scrollPane.setPreferredSize(new Dimension(350, 390));
		ingPanel.add(scrollPane);
	}
	
	private void initEquipPanel() {
		eqsPanel = new JPanel();
		
		Controller c = Controller.getController(null, null);
		ArrayList<Equipment> eqs = c.getModel().getEquipments();
		
		String[] cols = {"Select", "Name"};
		Object[][] values = new Object[eqs.size()][2];
		
		for (int i = 0; i < eqs.size(); i++) {
			values[i][0] = false;
			values[i][1] = eqs.get(i).getName();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(values, cols);
		eqsTable = new JTable(dtm){
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
			}
		};
		
		JScrollPane scrollPane = new JScrollPane(eqsTable);
		scrollPane.setPreferredSize(new Dimension(350, 390));
		eqsPanel.add(scrollPane);
	}
	
	private void initTagsPanel() {
		tagsPanel = new JPanel();
		
		Controller c = Controller.getController(null, null);
		ArrayList<MealTag> tags = c.getModel().getMealTags();
		
		String[] cols = {"Select", "Name"};
		Object[][] values = new Object[tags.size()][2];
		
		for (int i = 0; i < tags.size(); i++) {
			values[i][0] = false;
			values[i][1] = tags.get(i).getName();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(values, cols);
		tagsTable = new JTable(dtm){
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
			}
		};
		
		JScrollPane scrollPane = new JScrollPane(tagsTable);
		scrollPane.setPreferredSize(new Dimension(350, 390));
		tagsPanel.add(scrollPane);
	}
	
	
}
