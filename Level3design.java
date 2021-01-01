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

public class Level3design extends JPanel implements KeyListener{
	
	JFrame window = new JFrame("Aquarium - LEVEL 3 - HARD"); 
	
	Shooterlevel shooter = new Shooterlevel(400, 600, "images//gun3.png");
	Level3[][] level3 = new Level3[4][15]; 
	Level3[][] Boss = new Level3[1][1];
	int xAxis = 0;
	int yAxis = -300;
	Bullet[] bullet = new Bullet[1000];
	int counter = 0;
	Drop3 dropper = new Drop3(this, level3); 
	Drop3 dropboss = new Drop3(this, Boss);  
	

	Level3design(){
		this.setFocusable(true);
		this.addKeyListener(this);
		window.add(this);
 		
		for(int i = 0; i < Boss.length; i++) {
			for(int j = 0; j<Boss[i].length; j++) {
				Boss[i][j]  = new Level3(xAxis + 500 , yAxis - 150, "images//Balrog.png");  // set location of Boss
				xAxis += 70;
				
			}
			yAxis += 80;
			xAxis = 0;
		}
		dropboss.start();
		for(int i = 0; i<level3.length; i++) {
			for(int j = 0; j<level3[i].length; j++) {
				level3[i][j]  = new Level3(xAxis + 42 , yAxis, "images//Star.png");  // set location of 1st fish
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
	}
	public void paint(Graphics a) {
		ImageIcon background = new ImageIcon("images//Level 3.png"); 
		a.drawImage(background.getImage(), 0, 0, null);
		
		shooter.drawshooter(a);
		for(int i = 0; i < level3.length; i++ ) {
			for(int j = 0; j < level3[i].length; j++) {
				level3[i][j].drawlevel3(a);
			}
		}
		for(int i = 0; i < Boss.length; i++ ) {
			for(int j = 0; j < Boss[i].length; j++) {
				Boss[i][j].drawlevel3(a);
			}
		}
		
		for(int i = 0; i < bullet.length; i++) {
			bullet[i].drawBullet(a); 
		}
		// create the score
		a.setColor(Color.white);
		a.setFont(new Font("", Font.BOLD, 22));
		a.drawString("Score = " + (Fire3.score + Fire3.scoreboss), 70, 650);
		levelFailed();
		levelComplete();
	}
	// Ban het ca map thi WIN
	public void levelComplete() {
		if(Fire3.score + Fire3.scoreboss == 900) {
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null, "YOU WIN, Your score: " +(Fire3.score + Fire3.scoreboss) + "\n" + "Congratulations Game Completed");
		}
	}
	
	// khi ca map di het window thi gameover
	public void levelFailed() {
		
		for(int i = 0; i < level3.length; i++) {
			for(int j = 0; j < level3[i].length; j++) {
				if(level3[i][j].getyAxis() > 700){
					window.dispose();
					JOptionPane.showMessageDialog(null, "GAMEOVER !!!, Your score: " +(Fire3.score + Fire3.scoreboss));
					dropper.stop();
					break;
				}
			}
		}
		for(int i = 0; i < Boss.length; i++) {
			for(int j = 0; j < Boss[i].length; j++) {
				if(Boss[ i][j].getyAxis() > 1100){
					window.dispose();
					JOptionPane.showMessageDialog(null, "GAMEOVER !!!, Your score: " +(Fire3.score + Fire3.scoreboss));
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
		else if(e.getKeyCode() == KeyEvent.VK_H) {
			/*try{
				File sound = new File("sounds//Openingsound.wav");
				AudioInputStream sb = AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(sb);
				clip.start();
			}catch(Exception a) {System.out.println(e);} */
			
			bullet[counter].setxAxis(shooter.getxAxis() + 70); // set location of bullet so voi shooter  
			Fire3 f = new Fire3(bullet[counter], this, level3, Boss);

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
