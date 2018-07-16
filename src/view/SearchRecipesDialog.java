package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import listeners.searchActionListener;
import model.Equipment;
import model.Ingredient;
import model.MealTag;

public class SearchRecipesDialog extends JDialog {
	private JTabbedPane tabs;
	private JPanel ingPanel, eqPanel, tagPanel;
	public JTable ingTable, eqTable, tagTable;
	private JButton okButton;
	
	public SearchRecipesDialog(JFrame mainView) {
		super(mainView);
		initGui();
	}
	
	public void initGui() {
		setSize(360, 400);
		tabs = new JTabbedPane();
		initIngPanel();
		initEqPanel();
		initTagPanel();
		
		tabs.addTab("Ingredients", ingPanel);
		tabs.addTab("Equipment", eqPanel);
		tabs.addTab("Meal tags", tagPanel);
		add(tabs);
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
			values[i][2] = 0;
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
                        return Integer.class;
                    default:
                        return Boolean.class;
                }
			}
		};
		
		JScrollPane scrollPane = new JScrollPane(ingTable);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		ingPanel.add(scrollPane);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new searchActionListener(this));
		ingPanel.add(okButton);
		
	}
	
	private void initEqPanel() {
		eqPanel = new JPanel();
		
		Controller c = Controller.getController(null, null);
		ArrayList<Equipment> eqs = c.getModel().getEquipments();
		
		String[] cols = {"Select", "Name"};
		Object[][] values = new Object[eqs.size()][2];
		
		for (int i = 0; i < eqs.size(); i++) {
			values[i][0] = false;
			values[i][1] = eqs.get(i).getName();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(values, cols);
		eqTable = new JTable(dtm){
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
		
		JScrollPane scrollPane = new JScrollPane(eqTable);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		eqPanel.add(scrollPane);
	}
	
	private void initTagPanel() {
		tagPanel = new JPanel();
		
		Controller c = Controller.getController(null, null);
		ArrayList<MealTag> tags = c.getModel().getMealTags();
		
		String[] cols = {"Select", "Name"};
		Object[][] values = new Object[tags.size()][2];
		
		for (int i = 0; i < tags.size(); i++) {
			values[i][0] = false;
			values[i][1] = tags.get(i).getName();
		}
		
		DefaultTableModel dtm = new DefaultTableModel(values, cols);
		tagTable = new JTable(dtm){
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
		
		JScrollPane scrollPane = new JScrollPane(tagTable);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		tagPanel.add(scrollPane);
	}
}
