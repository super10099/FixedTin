package Entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import flappytin.GameLauncher;
import flappytin.ResourceLoader;

public class Pipe implements Entity{
	
	private Rectangle lPipeHitBox = new Rectangle();
	private Rectangle rPipeHitBox = new Rectangle();
	
	private BufferedImage lPipeImg = (BufferedImage) ResourceLoader.LOADED_ASSETS.get("lpipe.png");
	private BufferedImage rPipeImg = (BufferedImage) ResourceLoader.LOADED_ASSETS.get("rpipe.png");
	
	private int inbetween = 100; //the gap
	
	public Pipe() {
		lPipeHitBox.setSize(new Dimension(lPipeImg.getWidth(), lPipeImg.getHeight()));
		rPipeHitBox.setSize(new Dimension(rPipeImg.getWidth(), rPipeImg.getHeight()));
		
		Random rand = new Random();
		int xset = rand.nextInt(GameLauncher.WIDTH - inbetween);
		
		
		
		lPipeHitBox.setLocation(-(lPipeImg.getWidth() - xset), GameLauncher.HEIGHT - 50);
		rPipeHitBox.setLocation((int) (lPipeHitBox.getX() + lPipeHitBox.getWidth() + inbetween), GameLauncher.HEIGHT - 50);
		
	}
	
	public void ascend(int yOff) {
		lPipeHitBox.add(new Point(0, yOff));
		rPipeHitBox.add(new Point(0, yOff));
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.draw(lPipeHitBox);
		g.drawImage(lPipeImg, (int) lPipeHitBox.getX(), (int) lPipeHitBox.getY(), null);
		g.draw(rPipeHitBox);
		g.drawImage(rPipeImg, (int) rPipeHitBox.getX(), (int) rPipeHitBox.getY(), null);
	}

}
