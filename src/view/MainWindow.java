package view;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import enums.UserType;
import model.Result;


public class MainWindow extends JFrame {
	private static MainWindow win = null;
	private Controller controller;
	
	private ToolbarStandard toolbar;
	private JMenuBar menu;
	private JTable resultTable;
	private JScrollPane resultPanel;
	
	
	private MainWindow() {
		super("Dine Application");
	}
	
	
	public static MainWindow getMainWindow() {
		if (win == null)
			win = new MainWindow();
		return win;
	}
	
	
	public void initGui(UserType type) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
       
        toolbar = new ToolbarStandard(type);   
        add(toolbar, BorderLayout.NORTH);
        
        menu = new JMenuBar(); 
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        menu.add(file);
        menu.add(help);
        setJMenuBar(menu);
        
        
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void setTable(ArrayList<Result> results) {
		String[] cols = {"Name", "Desc", "Score"};
		Object[][] data = new Object[results.size()][3];
		
		for (int i = 0; i < results.size(); i++) {
			data[i][0] = results.get(i).recipe.getName();
			data[i][1] = results.get(i).recipe.getDesc();
			data[i][2] = results.get(i).score;
		}
		
		DefaultTableModel dtm = new DefaultTableModel(data, cols);
		resultTable = new JTable(dtm){
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    default:
                        return String.class;
                }
			}
		};
	}
	
	public void initTable(ArrayList<Result> results) {
		setTable(results);
		if (resultPanel != null)
			remove(resultPanel);
		resultPanel = new JScrollPane(resultTable);
		add(resultPanel);
		revalidate();
		repaint();
	}
	
	public void setNewToolbar(UserType type) {
		remove(toolbar);
		toolbar = new ToolbarStandard(type);
		add(toolbar, BorderLayout.NORTH);
		revalidate();
		repaint();
	}
	
	
	
}
