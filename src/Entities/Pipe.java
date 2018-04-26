package Entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class Pipe implements Entity{
	
	public int id = 0;
	
	private Rectangle lPipeHitBox = new Rectangle();
	private Rectangle rPipeHitBox = new Rectangle();
	
	private BufferedImage lPipeImg = (BufferedImage) ResourceLoader.LOADED_ASSETS.get("lpipe.png");
	private BufferedImage rPipeImg = (BufferedImage) ResourceLoader.LOADED_ASSETS.get("rpipe.png");
	
	private int inbetween = 100; //the gap
	
	private int height;
	private int yOff = GameLauncher.HEIGHT; // the yoffset of pipes
	
	public Pipe(int id) {
		this.id = id;
		height = lPipeImg.getHeight();
		lPipeHitBox.setSize(lPipeImg.getWidth(), height);
		rPipeHitBox.setSize(lPipeImg.getWidth(), height);
		
		Random rand = new Random();
		int xset = rand.nextInt(GameLauncher.WIDTH - inbetween);
		
		
		
		lPipeHitBox.setLocation(-(lPipeImg.getWidth() - xset), yOff);
		rPipeHitBox.setLocation((int) (lPipeHitBox.getX() + lPipeHitBox.getWidth() + inbetween), yOff);
		
	}
	
	public void ascend(int dYOff) {
		yOff -= dYOff;
		lPipeHitBox.setLocation((int) lPipeHitBox.getX(), yOff);
		rPipeHitBox.setLocation((int) rPipeHitBox.getX(), yOff);
	}
	
	public Rectangle[] getHitBox(){
		return new Rectangle[] {lPipeHitBox, rPipeHitBox};
	}
	
	public int getYOff() {
		return yOff;
	}
	
	public int getHeight() {
		return height;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		//g.fill(lPipeHitBox);
		g.drawImage(lPipeImg, (int) lPipeHitBox.getX(), (int) lPipeHitBox.getY(), null);
		//g.fill(rPipeHitBox);
		g.drawImage(rPipeImg, (int) rPipeHitBox.getX(), (int) rPipeHitBox.getY(), null);
	}

}
