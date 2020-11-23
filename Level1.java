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
		 if (xAxis < 0)
        	xAxis = 1;
                if(yAxis < 0)
        	yAxis = 1;
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
	public void drawlevel1(Graphics a) {
		ImageIcon fish = new ImageIcon(imageFish);
		a.drawImage(fish.getImage(), xAxis, yAxis, null);	
	}
	
	public void move() {
        Random randomMove = new Random();
        Direction directionMove = Direction.values()[randomMove.nextInt(6)];
        switch (directionMove) 
            {
                case North:
                    yAxis =  yAxis - 1;
                    break;
                case NorthEast:
                	yAxis =  yAxis - 1;
                    xAxis = xAxis + 1;
                    break;
                case East:
                	 xAxis = xAxis + 1;
                    break;
                case South:
                	yAxis =  yAxis + 1;
                    break;
                case SouthWest:
                    yAxis =  yAxis + 1;
                    xAxis = xAxis - 1;
                    break;
                case West:
                    xAxis = xAxis - 1;
                    break;
                case NorthWest:
                    yAxis =  yAxis - 1;
                    xAxis = xAxis - 1;
                    break;
                default:
                	xAxis = xAxis;
                	yAxis =  yAxis;
                    break;
            }
    }
}
