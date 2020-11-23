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
	
	JFrame window = new JFrame("LEVEL 1 - EASY"); 
	
	Shooterlevel1 shooter = new Shooterlevel1(400, 500, "images//Shooter.png");
	Level1[][] level1 = new Level1[2][12]; 
	int xAxis = random1.nextInt(300);
	int yAxis = random1.nextInt(300);
	Bullet[] bullet = new Bullet[1000];
	int counter = 0;
	Drop dropper = new Drop(this, level1); 
	

	Level1design(){
		this.setFocusable(true);
		this.addKeyListener(this);
		window.add(this);
 		
		for(int i = 0; i<level1.length; i++) {
			for(int j = 0; j<level1[i].length; j++) {
				llevel1[i][j]  = new Level1(xAxis  , yAxis, "images//Mother Move 1.png");  // set location of 1st fish
				xAxis += 80;
				
			}
			yAxis += 70;
			xAxis = 0;
		}
		dropper.start();
		
		for(int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet(470, 600, "images//bullet.jpg");
		}


		window.setSize(1000,600);
		window.setLocation(250, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	public void paint(Graphics a) {
		ImageIcon background = new ImageIcon("images//background.jpg"); 
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
		a.setColor(Color.black);
		a.setFont(new Font("", Font.BOLD, 22));
		a.drawString("Score = " + Fire.score, 750, 550);
		levelFailed();
		levelComplete();
	}
	// Ban het ca map thi WIN
	public void levelComplete() {
		if(Fire.score >= 240) {
			window.dispose();
			dropper.stop();
			JOptionPane.showMessageDialog(null, "YOU WIN, Your score: " +Fire.score);
		}
	}
	
	// khi ca map di het window thi gameover
	public void levelFailed() {
		
		for(int i = 0; i < level1.length; i++) {
			for(int j = 0; j < level1[i].length; j++) {
				if(level1[i][j].getyAxis() > 500){
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
