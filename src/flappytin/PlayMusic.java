package flappytin;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.*;

public class PlayMusic {
	
	
	private AudioInputStream in;
	private Clip clip;
	
	public PlayMusic(String uri) {
		ClassLoader cLoader = getClass().getClassLoader();
		try {
			URL musicURL = (URL) ResourceLoader.LOADED_ASSETS.get(uri);
			in = AudioSystem.getAudioInputStream(musicURL);
			clip = AudioSystem.getClip();
			clip.open(in);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}
	
	public void turnOff() {
		clip.stop();
		clip.close();
	}
}
