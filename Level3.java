package shootfeedFish;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Level3 {
	private int xAxis;
	private int yAxis; 
	private String imageFish;
	public Level3(int xAxis, int yAxis, String imageFish) {
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
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public String getImageFish() {
		return imageFish;
	}
	public void setImageFish(String imageFish) {
		this.imageFish = imageFish;
	}
	public void drawlevel3(Graphics a) {
		ImageIcon fish = new ImageIcon(imageFish);
		a.drawImage(fish.getImage(), xAxis, yAxis, null);
		
	}
}

