package GameStates;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected boolean initialized = false;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public boolean getInit() {
		return initialized;
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	
}
