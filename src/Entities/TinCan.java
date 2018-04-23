package Entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class TinCan implements Entity {
	
	private ArrayList<BufferedImage> states = new ArrayList<BufferedImage>();
	private int currentState = 0; // normal state of tincan
	
	private Rectangle hitBox = new Rectangle();
	private Point position = new Point();
	private double angleOfRotation = 0;
	
	//movement
	private int xVel = 10;
	
	public TinCan() {
		
		states.add((BufferedImage) ResourceLoader.LOADED_ASSETS.get("Tin_Can.png"));
		hitBox.setSize(new Dimension(states.get(currentState).getWidth(), states.get(currentState).getHeight()));
		
	}
	
	public void move(int constant) {
		position.setLocation(position.getX() + (constant*xVel), position.getY());
	}
	
	public void setAngleOfRotation(double d) {
		angleOfRotation = d;
	}
	
	public void setPosition(int x, int y) {
		this.position.setLocation(x, y);
	}
	
	public void setState(int state) {
		this.currentState = state;
	}
	
	public int getWidth() {
		return states.get(currentState).getWidth();
	}
	
	public int getHeight() {
		return states.get(currentState).getHeight();
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}
	
	@Override
	public void draw(Graphics2D g) {
		AffineTransform at = new AffineTransform();
		at.translate(position.getX(), position.getY());
		at.rotate(angleOfRotation, states.get(currentState).getWidth()/2, states.get(currentState).getHeight()/2);
		Shape outline = at.createTransformedShape(hitBox);
		g.draw(outline);
		g.drawImage(states.get(currentState), at, null);
		
		Shape bounds = at.createTransformedShape(new Rectangle(states.get(currentState).getWidth(), states.get(currentState).getHeight()));
		g.draw(bounds.getBounds());
		
		if (bounds.getBounds().getX() < 0) {
			
		}
	}
	
}
