package flappytin;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Background {
	
	
	private BufferedImage bgImg;
	
	private double x;
	private double y;
	
	private double dx;
	private double dy;
	
	
	public Background(String uri, double x, double y) {
		bgImg = (BufferedImage) ResourceLoader.LOADED_ASSETS.get(uri);
		this.x = x;
		this.y = y;
	}
	
	
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void tick() {
		
		if (x > GameLauncher.WIDTH) {
			x = 0 - bgImg.getWidth() + GameLauncher.WIDTH;
		}
		
		x += dx;
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bgImg, (int) x, (int) y, null);
		
		if (x > 0) {
			g.drawImage(bgImg, (int) x - bgImg.getWidth(), (int) y, null);
		} else if (x < 0) {
			g.drawImage(bgImg, (int) x + bgImg.getWidth(), (int) y, null);
		}
		
	}
}
