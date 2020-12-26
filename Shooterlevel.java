package shootfeedFish;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Shooterlevel1 {
	private int xAxis;
	private int yAxis; 
	private String imageShoot;
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public String getImageShoot() {
		return imageShoot;
	}
	public void setImageShoot(String imageShoot) {
		this.imageShoot = imageShoot;
	}
	public Shooterlevel1(int xAxis, int yAxis, String imageShoot) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imageShoot = imageShoot;
	}
	public void drawshooter(Graphics a) {
		ImageIcon shooter = new ImageIcon(imageShoot);
		a.drawImage(shooter.getImage(), xAxis, yAxis, null); 
		
	}

}
