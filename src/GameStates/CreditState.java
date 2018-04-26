package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class CreditState extends GameState{
	
	private String[][] creditStrings = {
			
			{
				"Idea thinker",
				"Scripting kiddie",
				"image makers",
				"special thanks to",
			},
			
			{
				"Tin can", 
				"Tin can",
				"google",
				"flappy bird",
				
			},
			
			
			
	};
	
	public CreditState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		initialized = true;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) ResourceLoader.LOADED_ASSETS.get("flappymenubg.png"), 0, 0, null);;
		g.setColor(Color.WHITE);
		
		int inter = 1;
		for (int i = 0; i<1; i++) {
			for (int j = 0; j<creditStrings[i].length; j++) {
				System.out.println(creditStrings[i][j]);
				g.drawString(creditStrings[i][j], (GameLauncher.WIDTH - g.getFontMetrics().stringWidth(creditStrings[i][j])) / 2, 30 * inter);
				g.drawString(creditStrings[i+1][j], (GameLauncher.WIDTH - g.getFontMetrics().stringWidth(creditStrings[i+1][j])) / 2, 30 * (++inter));
				inter++;
			}
		}
		
		g.setFont(new Font("SansSerif", Font.BOLD, 28));
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deInit() {
		// TODO Auto-generated method stub
		
	}

}
