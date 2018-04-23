package flappytin;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import GameStates.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private GameStateManager gsm;
	
	private boolean isRunning = false;
	private Thread thread;
	
	public GamePanel(Dimension d) {
		setPreferredSize(d);
		
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		gsm = new GameStateManager();
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void tick() {
		repaint();
		gsm.tick();
	}
	
	public void render() {
		
	}

	@Override
	public void run() {
		
		
		
		double TARGET_FPS = 1000000000/60;
		
		long lastTime = System.nanoTime();
		double deltaT = 0;
		
		boolean render = false;
		
		double fpsTimer = System.currentTimeMillis();
		int frames = 0;
		
		while (isRunning) {
			long now = System.nanoTime();
			deltaT += (now - lastTime) / TARGET_FPS;
			lastTime = now;
			render = false;
			
			while (deltaT >= 1) {
				deltaT--;
				tick();
				render = true;
			}
			
			if (render) {
				frames++;
				render();
			}
			
			//fps counter
			if (System.currentTimeMillis() - fpsTimer >= 1000) {
				fpsTimer += 1000;
				frames = 0;
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		gsm.draw(g2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		gsm.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		gsm.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
