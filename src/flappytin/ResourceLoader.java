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
			
			
			LOADED_ASSETS.put("flappymenubg.png", ImageIO.read(cLoader.getResource("flappymenubg.png")));
			
			LOADED_ASSETS.put("Tin_Can.png", ImageIO.read(cLoader.getResource("Tin_Can.png")));
			
			LOADED_ASSETS.put("lpipe.png", ImageIO.read(cLoader.getResource("lpipe.png")));
			
			LOADED_ASSETS.put("rpipe.png", ImageIO.read(cLoader.getResource("rpipe.png")));
			
			
			
			
			LOADED_ASSETS.put("resizedCreditBG.png", ImageIO.read(cLoader.getResource("resizedCreditBG.png")));
						
			LOADED_ASSETS.put("216848_8_bit_shit.wav", cLoader.getResource("216848_8_bit_shit.wav"));
			
			LOADED_ASSETS.put("359466_Skullbeatz___We_Heart_8_Bi.wav", cLoader.getResource("359466_Skullbeatz___We_Heart_8_Bi.wav"));
			
			LOADED_ASSETS.put("291458_Waterflame___Time_machine.wav", cLoader.getResource("291458_Waterflame___Time_machine.wav"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
