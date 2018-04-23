package GameStates;

import flappytin.ResourceLoader;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import flappytin.GameLauncher;

public class MenuState extends GameState{
	
	private BufferedImage bgImage = null;
	
	String[] selections = {"Play", "How To Play", "Credits"};
	private int currentSelection = 0;

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		initialized = true;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) ResourceLoader.LOADED_ASSETS.get("flappymenubg.png"), 0, 0, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		FontMetrics fm = g.getFontMetrics();
		for (int i=0; i<selections.length; i++) {
			int x = (GameLauncher.WIDTH - fm.stringWidth(selections[i])) / 2;
			int y = 130 + 30*i;
			
			if (i == currentSelection) {
				g.setColor(Color.WHITE);
			}
			
			g.drawString(selections[i], x, y);
			g.setColor(Color.BLACK);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//selectino go up
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			if (currentSelection <= 0) {
				currentSelection = selections.length-1;
			} else {
				currentSelection--;
			}
		// selection go down
		} else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			currentSelection = (currentSelection + 1) % 3;
		// enter
		} else if (keyCode == KeyEvent.VK_ENTER) {
			switch (currentSelection) {
				case 0: // PLAY
					System.out.println("PLAY");
					gsm.pushState(gsm.PLAY_STATE);
					break;
				case 1: // tutorial
					System.out.println("TUTORIAL");
					gsm.pushState(gsm.TUTORIAL_STATE);
					break;
				case 2: // credits
					System.out.println("CREDITS");
					gsm.pushState(gsm.CREDIT_STATE);
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	
}
