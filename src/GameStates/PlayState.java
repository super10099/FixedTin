package GameStates;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import Entities.Pipe;
import Entities.TinCan;
import flappytin.GameLauncher;
import flappytin.PlayMusic;
import flappytin.ResourceLoader;

public class PlayState extends GameState{
	
	private int pipeCount = 0;
	private int score = 0;
	
	private TinCan tinCan;
	
	private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	private Iterator<Pipe> pipeIterator;
	
	private int pipeInterval = 60 * 6/8; // pipe per 60 ticks
	private int tickCount = pipeInterval; // start at interval, so pipe is created immediately
	private int pipeSpeed = 5;
	private int nominalY = 25; // yPos of tinCan
	
	private double baseRotation = 25;
	
	private boolean left = false;
	private boolean right = false;
	
	private PlayMusic mplayer;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		tinCan = new TinCan();
		tinCan.setState(0);
		tinCan.setPosition(GameLauncher.WIDTH/2 - tinCan.getWidth()/2, nominalY);
		
		//PLAY MUSIC FUCK YEAH!!!
		mplayer = new PlayMusic("291458_Waterflame___Time_machine.wav");
		mplayer.play();
		initialized = true;
	}
	
	public void gameOver() {
		gsm.popState();
		gsm.pushState(gsm.MENU_STATE);
	}
	
	//gets called when state is popped
	public void deInit() {
		mplayer.turnOff();
		initialized = false;
	}

	@Override
	public void tick() {
		
		tickCount++;
		if (tickCount >= pipeInterval) {
			tickCount = 0;
			pipeCount++;
			pipes.add(new Pipe(pipeCount));
		}
		
		//orientation and movement
		if (left && right) {
			tinCan.setAngleOfRotation(Math.toRadians(0));
		} else if (left) {
			tinCan.setAngleOfRotation(Math.toRadians(baseRotation));
			tinCan.move(-1);
		} else if (right) {
			tinCan.setAngleOfRotation(Math.toRadians(-baseRotation));
			tinCan.move(1);
		} else {
			tinCan.setAngleOfRotation(Math.toRadians(0));
		}
		
		//ascend each pipe
		pipeIterator = pipes.iterator();
		Rectangle[] pipeHitBoxes;
		Rectangle tinCanHitBox;
		while (pipeIterator.hasNext()) {
			Pipe pipe = pipeIterator.next();
			pipe.ascend(pipeSpeed);
			
			//check for collisions
			pipeHitBoxes = pipe.getHitBox();
			tinCanHitBox = tinCan.getHitBox();
			if (pipeHitBoxes[0].intersects(tinCanHitBox) == true || pipeHitBoxes[1].intersects(tinCanHitBox) == true) {
				gameOver();
				((MenuState)gsm.MENU_STATE).setHighScore(score);
			}
			
			//check point
			if (pipe.getYOff() <= -20) {
				score++;
				pipeIterator.remove();
			}
		}
		
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) ResourceLoader.LOADED_ASSETS.get("flappymenubg.png"), 0, 0, null);
		String scrStr = "score: " + score;
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 22));
		g.drawString(scrStr, (GameLauncher.WIDTH - g.getFontMetrics().stringWidth(scrStr)) / 2, 17);
		tinCan.draw(g);
		//draw each pipe
		pipeIterator = pipes.iterator();
		while (pipeIterator.hasNext()) {
			pipeIterator.next().draw(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyP = e.getKeyCode();
		switch (keyP) {
		
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			right = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyP = e.getKeyCode();
		
		switch (keyP) {
		
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			right = false;
			break;
		}
	}

}
