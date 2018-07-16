package view;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import controller.Controller;
import enums.UserType;


public class MainWindow extends JFrame {
	private static MainWindow win = null;
	private Controller controller;
	
	private ToolbarStandard toolbar;
	private JMenuBar menu;
	
	
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
        
        // Depending of active user different toolbar settings are set.
    
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
        this.setLocationRelativeTo(null);
	}
	
	public void setNewToolbar(UserType type) {
		remove(toolbar);
		toolbar = new ToolbarStandard(type);
		add(toolbar, BorderLayout.NORTH);
		revalidate();
		repaint();
		
	}
	
}
