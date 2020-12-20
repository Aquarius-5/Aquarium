package shootfeedFish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//The 2nd window 
public class MenuWindow extends JPanel implements ActionListener,KeyListener{
	
	// Declare 
	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JLabel centerImageLable = new JLabel();
	JLabel settingButton = new JLabel();
	JLabel information = new JLabel();
	
	//Design Menu Window that have a play and exit button
	MenuWindow()
	{
		
		
		window.setForeground(Color.DARK_GRAY);
		window.add(this);
		
		//Design play button
		playButton.setBackground(Color.black);
		playButton.setIcon(new ImageIcon("images//play.jpg"));
		playButton.addActionListener(this);
		playButton.addKeyListener(this);
		window.add(playButton, BorderLayout.PAGE_START);
		
		//Design end button
		exitButton.setBackground(Color.black);
		exitButton.setIcon(new ImageIcon("images//exist.jpg"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		window.add(exitButton, BorderLayout.PAGE_END);
		
		
		// Set Window's Properties
		window.setLocation(100, 10);
		window.setUndecorated(true);
		window.setSize(1300, 700);
		window.setVisible(true);	
		
	}
	
    // Set the Background
	public void paint(Graphics game) {
		ImageIcon background = new ImageIcon("images//menubackground.jpg"); 
		
		game.drawImage(background.getImage(), 0, 0, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
		window.dispose();
		}
		else if((e.getSource() == playButton)){
			window.dispose(); //closing the previous window
			PlayWindow pw = new PlayWindow();
		}
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
    	   window.dispose(); //closing the previous window
       }
       else if(e.getKeyCode() ==  KeyEvent.VK_ENTER) {
    	   window.dispose(); //closing the previous window
    	   PlayWindow pw = new PlayWindow();
       }
	}

	
	public void keyReleased(KeyEvent e) {
		
	}
}
