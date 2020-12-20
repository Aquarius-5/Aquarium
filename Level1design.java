package shootfeedFish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Level1design extends JPanel implements KeyListener{
	
	JFrame window = new JFrame("Aquarius - LEVEL 1 - EASY"); 
	Random random1 = new Random();
	Shooterlevel shooter = new Shooterlevel(400, 550, "images//Shooter.png");
	Level1[][] level1 = new Level1[2][15];
	int xAxis = 0;
	int yAxis = 0;
	Bullet[] bullet = new Bullet[1000];
	int counter = 0;
	Drop dropper = new Drop(this, level1); 
	
	Level1design(){
		this.setFocusable(true);
		this.addKeyListener(this);
		window.add(this);
 		
		for(int i = 0; i<level1.length; i++) {
			for(int j = 0; j<level1[i].length; j++) {
				level1[i][j]  = new Level1(xAxis  , yAxis, "images//Mother Move 1.png");
				xAxis += 70;	
			}
			yAxis += 80;
			xAxis = 0;
		}
	    
        dropper.start();
        
        
		for(int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet(470, 700, "images//bullet.png");
		}


		window.setSize(1100,733);
		window.setLocation(250, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		try {
		File sound = new File("sounds//Level1Sound.wav");
		AudioInputStream sb = AudioSystem.getAudioInputStream(sound);
		Clip clip = AudioSystem.getClip();
		clip.open(sb);
		clip.start();
		
	    }catch(Exception e) {System.out.println(e);}
	}
	public void paint(Graphics a) {
		ImageIcon background = new ImageIcon("images//level 1 fixed.png"); 
		a.drawImage(background.getImage(), 0, 0, null);
		
		shooter.drawshooter(a);
		for(int i = 0; i < level1.length; i++ ) {
			for(int j = 0; j < level1[i].length; j++) {
				level1[i][j].drawlevel1(a);
			}
		}
		for(int i = 0; i < bullet.length; i++) {
			bullet[i].drawBullet(a); 
		}
		// create the score
		a.setColor(Color.white);
		a.setFont(new Font("", Font.BOLD, 22));
		a.drawString("Score = " + Fire.score, 70, 650);
		levelFailed();
		levelComplete();
	}
	// Ban het ca map thi WIN
	@SuppressWarnings("deprecation")
	public void levelComplete() {
		if(Fire.score >= 300) {
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null, "YOU WIN, Your score: " +Fire.score + "\n" + "Click OK to Next level"); 
			Level2design l2 = new Level2design();
		}
	}
	
	// khi ca map di het window thi gameover
	public void levelFailed() {
		
		for(int i = 0; i < level1.length; i++) {
			for(int j = 0; j < level1[i].length; j++) {
				if(level1[i][j].getyAxis() > 620){
					window.dispose();
					JOptionPane.showMessageDialog(null, "GAMEOVER !!!, Your score: " +Fire.score);
					dropper.stop();
					
					break;
				}
			}
		}

}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(shooter.getxAxis() < 1500)
				 shooter.setxAxis(shooter.getxAxis() + 25); // set speed of shooter
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(shooter.getxAxis() > -2) {
				shooter.setxAxis(shooter.getxAxis() - 25); // set speed of shooter
			}
			this.repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			/*try{
				File sound = new File("sounds//Openingsound.wav");
				AudioInputStream sb = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(sb);
				clip.start();
			}catch(Exception a) {System.out.println(e);} */
			
			bullet[counter].setxAxis(shooter.getxAxis() + 70); // set location of bullet so voi shooter  
			Fire f = new Fire(bullet[counter], this, level1);
			bullet[counter].setyAxis(shooter.getyAxis() + 70);
			f.start();
			counter++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
