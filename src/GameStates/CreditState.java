package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import flappytin.Background;
import flappytin.GameLauncher;
import flappytin.PlayMusic;
import flappytin.ResourceLoader;

public class CreditState extends GameState{
	
	private Background bg;
	
	private double yInt = 100;
	private double y = 100;
	private double dy = 0.15;
	
	PlayMusic mplayer;
	
	private String[][] creditStrings = {
			
			{
				"Idea thinker",
				"Scripting kiddie",
				"Menu Background Image",
				"Pipe Image",
				"Menu Music [Royal Free]",
				"Link",
				"Play Music [Royal Free]",
				"Link",
				"Credit Scene Music [Royal Free]",
				"Link",
				"special thanks to",
				"Mrs. Kristen Sailors.",
				" ",
				" ",
				"Source Code"
			},
			
			{
				"Thinh Nguyen", 
				"Thinh Nguyen",
				"https://ellisonleao.github.io/",
				"http://pixelart.studio/",
				"rickandmorty.wikia.com",
				"\"8-Bit\" by Father-of-Death", "https://www.newgrounds.com/audio/listen/216848",
				"\"-Time Machine-\" by Waterflame", "https://www.newgrounds.com/audio/listen/291458",
				"\"We Heart 8-Bit\" by Skullbeatz", "https://www.newgrounds.com/audio/listen/359466",
				"my teacher",
				" ",
				" ",
				" ",
				"https://github.com/super10099/TinCanFromTheHeights"
			},
			
			
			
	};
	
	public CreditState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		mplayer = new PlayMusic("359466_Skullbeatz___We_Heart_8_Bi.wav");
		mplayer.play();
		
		// TODO Auto-generated method stub
		y = yInt;
		
		bg = new Background("resizedCreditBG.png", -480, 0);
		bg.setVector(.18, 0);
		
		initialized = true;
	}
	
	public void deInit() {
		mplayer.turnOff();
		initialized = false;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		bg.tick();
		y += dy;
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(Color.WHITE);
		
		Font header = new Font("SansSerif", Font.BOLD, 16);
		Font sub = new Font("Arial", Font.ITALIC, 14);
		
		int inter = 1;
		for (int i = 0; i<1; i++) {
			for (int j = 0; j<creditStrings[i].length; j++) {
				if ((y - yInt)/30 > ((30*inter)/30)) {
					g.setFont(header);
					g.drawString(creditStrings[i][j], (GameLauncher.WIDTH - g.getFontMetrics().stringWidth(creditStrings[i][j])) / 2,(int) ((30 * inter)+(GameLauncher.HEIGHT - y)));
				}
				
				if ((y - yInt)/30 > ((30*inter)/30)+1) {
					g.setFont(sub);
					g.drawString(creditStrings[i+1][j], (GameLauncher.WIDTH - g.getFontMetrics().stringWidth(creditStrings[i+1][j])) / 2,(int) (30 * (++inter)+(GameLauncher.HEIGHT - y)));
				}
				inter++;
			}
		}
		
		
		
	}
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.popState();
		gsm.pushState(gsm.MENU_STATE);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
