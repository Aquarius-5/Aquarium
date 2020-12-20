package shootfeedFish;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Level1 {
	private int xAxis;
	private int yAxis; 
	private String imageFish;
		public Level1(int xAxis, int yAxis, String imageFish) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.imageFish = imageFish;
		

	}
	
	public int getxAxis() {
		return xAxis;
	}
	
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public int getyAxis() {
		return yAxis;
	}
	public String getImageFish() {
		return imageFish;
	}
	public void setImageFish(String imageFish) {
		this.imageFish = imageFish;
	}
	public void drawlevel1(Graphics a) {
		ImageIcon fish = new ImageIcon(imageFish);
		a.drawImage(fish.getImage(), xAxis, yAxis, null);	
	}
	
}
