package flappytin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameLauncher extends JFrame{
	
	private static final String TITLE = "Tin Can From The Heights";
	
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
		//icon
				try {
					BufferedImage image = ImageIO.read(getClass().getResource("/Tin_Can.png"));
					setIconImage(image);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		new ResourceLoader();
		new GameLauncher();
	}
}
