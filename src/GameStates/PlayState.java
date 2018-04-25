package GameStates;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import Entities.Pipe;
import Entities.TinCan;
import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class PlayState extends GameState{
	
	private int pipeCount = 0;
	private int score = 0;
	
	private TinCan tinCan;
	
	private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	private Iterator<Pipe> pipeIterator;
	
	private int pipeInterval = 60 * 15/10; // pipe per 60 ticks
	private int tickCount = pipeInterval; // start at interval, so pipe is created immediately
	private int pipeSpeed = 2;
	private int nominalY = 10;
	
	private double baseRotation = 25;
	
	private boolean left = false;
	private boolean right = false;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		tinCan = new TinCan();
		tinCan.setState(0);
		tinCan.setPosition(GameLauncher.WIDTH/2 - tinCan.getWidth()/2, nominalY);
		initialized = true;
	}
	
	public void gameOver() {
		gsm.popState();
	}
	
	//gets called when state is popped
	public void deInit() {
		
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
			}
			
			//check point
			if (pipe.getYOff() <= 20) {
				//pipeIterator.remove();
			}
		}
		
		
	}

	@Override
	public void draw(Graphics2D g) {
		//g.drawImage((Image) ResourceLoader.LOADED_ASSETS.get("polgyonMI.jpg"), 0, 0, null);
		g.setColor(Color.BLACK);
		g.fill(new Rectangle(GameLauncher.WIDTH, GameLauncher.HEIGHT));
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
