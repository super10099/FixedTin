package flappytin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResourceLoader {
	
	public final static HashMap<String, Object> LOADED_ASSETS = new HashMap<String, Object>();
	
	public ResourceLoader() {
		
		ClassLoader cLoader = getClass().getClassLoader();
		
		try {
			BufferedImage flappyBG = ImageIO.read(new File(cLoader.getResource("flappymenubg.png").toURI()));
			LOADED_ASSETS.put("flappymenubg.png", flappyBG);
			
			BufferedImage normalCan = ImageIO.read(new File(cLoader.getResource("Tin_Can.png").toURI()));
			LOADED_ASSETS.put("Tin_Can.png", normalCan);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}
