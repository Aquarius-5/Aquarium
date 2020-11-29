package shootfeedFish;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


// The 1st window that conclude only the background and audio 
public class OpenningWindow extends JPanel {                                   
	
	JFrame window = new JFrame();
	
	OpenningWindow() 
	{
		window.add(this);
		
	 //Get audio
		try {
			File sound = new File("sounds//background sound.wav");
		
			AudioInputStream sb = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(sb);
			clip.start(); 
		
		
	    }catch(Exception e) {System.out.println(e);}
		
	// Set Window's Properties
		window.setLocation(500, 200);
		window.setUndecorated(true);
		window.setSize(539, 400);
		window.setVisible(true);
		
		
	 //Set time to close the first window and open the next one
		try {
			Thread.sleep(5000);
			window.dispose();
			MenuWindow m = new MenuWindow();
		}catch(Exception e) {System.out.println(e);}
		}
	
	// Set the Background
	public void paint(Graphics game) {
		ImageIcon background = new ImageIcon("images//open.png"); 
		game.drawImage(background.getImage(), 0, 0, null); 
	//Cai nay la dung de load Game nhung chua xong
		//ImageIcon shark = new ImageIcon("images//Shark level 2.png"); 
		/*for (int i = 300; i <= 1000; i+=50) {
			//game.drawImage(shark.getImage(), i, 500, null);
			//game.fillRect(i, 500, 50, 50);
		try {
			Thread.sleep(1000);
        }catch (Exception e) {System.out.println(e);}
		}*/
	}
}
