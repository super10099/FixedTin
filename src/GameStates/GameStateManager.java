package GameStates;



import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class GameStateManager {
	
	protected final GameState MENU_STATE;
	protected final GameState PLAY_STATE;
	protected final GameState TUTORIAL_STATE;
	protected final GameState CREDIT_STATE;
	
	private Stack<GameState> states;
	
	
	public GameStateManager() {
		states = new Stack<GameState>();
		
		//adding credit state
		CREDIT_STATE = new CreditState(this);
		states.push(CREDIT_STATE);
		
		//adding tutorial state
		TUTORIAL_STATE = new TutorialState(this);
		states.push(TUTORIAL_STATE);
		
		// adding playstate
		PLAY_STATE = new PlayState(this);
		PLAY_STATE.init();
		states.push(PLAY_STATE);
		
		//adding menustate
		MENU_STATE = new MenuState(this);
		states.push(MENU_STATE);
		MENU_STATE.init();
		
		
	}
	
	public void pushState(GameState state) {
		//System.out.println(state + "DA HELL" );
		states.push(state);
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
