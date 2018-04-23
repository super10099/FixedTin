package flappytin;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class GameLauncher extends JFrame{
	
	private static final String TITLE = "TCFTH";
	
	public final static int WIDTH = 350;
	public final static int HEIGHT = 500;
	
	//game instance
	private JFrame jframe;
	private GamePanel gpanel;
	
	//constructor
	public GameLauncher() {
		jframe = new JFrame(TITLE);
		gpanel = new GamePanel(new Dimension(WIDTH, HEIGHT));
		
		jframe.add(gpanel);
		
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new ResourceLoader();
		new GameLauncher();
	}
}
