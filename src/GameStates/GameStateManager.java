package GameStates;



import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class GameStateManager {
	
	protected GameState MENU_STATE = null;
	protected GameState PLAY_STATE = null;
	protected GameState TUTORIAL_STATE = null;
	protected GameState CREDIT_STATE = null;
	
	private Stack<GameState> states;
	
	
	public GameStateManager() {
		states = new Stack<GameState>();
	}
	
	
	public GameState createMenuState() {
		GameState newState = new MenuState(this);
		MENU_STATE = newState;
		newState.init();
		return newState;
	}
	
	public GameState createGameState() {
		GameState newState = new PlayState(this);
		PLAY_STATE = newState;
		newState.init();
		return newState;
		
	}
	
	public GameState createTutorialState() {
		GameState newState = new TutorialState(this);
		TUTORIAL_STATE = newState;
		newState.init();
		return newState;
	}
	
	public GameState createCreditState() {
		GameState newState = new CreditState(this);
		CREDIT_STATE = newState;
		newState.init();
		return newState;
	}
	
	
	public void popState() {
		states.peek().deInit();
		states.pop();
	}
	
	public void pushState(GameState state) {
		if (!state.initialized) {
			state.init();
		}
		states.push(state);
	}
	
	public Stack getStack() {
		return states;
	}
	
	public void tick() {
		GameState gs = states.peek();
		if (gs.getInit())
			gs.tick();
	}
	public void draw(Graphics2D g) {
		GameState gs = states.peek();
		if (gs.getInit())
			gs.draw(g);
	}
	
	public void keyPressed(KeyEvent e) {
		GameState gs = states.peek();
		if (gs.getInit())
			gs.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		GameState gs = states.peek();
		if (gs.getInit())
			gs.keyReleased(e);
	}
}
