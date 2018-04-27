package flappytin;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.*;

public class PlayMusic {
	
	
	private AudioInputStream in;
	private Clip clip;
	
	public PlayMusic(String uri) {
		ClassLoader cLoader = getClass().getClassLoader();
		try {
			File music = new File(cLoader.getResource(uri).toURI());
			System.out.println(music.exists());
			in = AudioSystem.getAudioInputStream(music);
			clip = AudioSystem.getClip();
			clip.open(in);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | URISyntaxException e) {
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
