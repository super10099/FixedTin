package GameStates;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import Entities.TinCan;
import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class PlayState extends GameState{
	
	private TinCan tinCan;
	
	private double baseRotation = 45;
	
	private boolean left = false;
	private boolean right = false;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		tinCan = new TinCan();
		tinCan.setState(0);
		tinCan.setPosition(GameLauncher.WIDTH/2 - tinCan.getWidth()/2, 10);
		initialized = true;
	}

	@Override
	public void tick() {
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
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage((Image) ResourceLoader.LOADED_ASSETS.get("flappymenubg.png"), 0, 0, null);
		tinCan.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyP = e.getKeyCode();
		switch (keyP) {
		
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyP = e.getKeyCode();
		
		switch (keyP) {
		
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		}
	}

}
