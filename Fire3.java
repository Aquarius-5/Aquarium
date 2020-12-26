package shootfeedFish;

import java.awt.Rectangle;

public class Fire3 extends Thread{ 
	
	
	Bullet bullet;
	Level3design g1;
	Level3[][] level3;
	Level3[][] Boss;
	public static int score = 0;
	public static int scoreboss = 0;
	
	Fire3(Bullet bullet, Level3design g1, Level3[][] level3, Level3[][] Boss){
		this.bullet = bullet;
		this.g1 = g1;
		this.level3 = level3;
		this.Boss= Boss;
	}
	
	
	@Override
	public void run() {
		while(bullet.getyAxis() > -100) {
			bullet.setyAxis(bullet.getyAxis() - 40);  // set speed of bullet ban ra
			checkColl();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g1.repaint();
		}
	}
	public void checkColl() {
		Rectangle bulletRec = new Rectangle(bullet.getxAxis(), bullet.getyAxis(), 14, 20); 
		
		for(int i = 0; i < level3.length; i++) {
			for(int j = 0; j < level3[i].length; j++) {
				Rectangle level1Rec = new Rectangle(level3[i][j].getxAxis(), level3[i][j].getyAxis(), 25, 25);
				if(bulletRec.intersects(level1Rec)) {
					level3[i][j].setxAxis(1000000);
					bullet.setxAxis(-10000);
					score += 10 ; 
				}
			}
		}
		for(int i = 0; i < Boss.length; i++) {
			for(int j = 0; j < Boss[i].length; j++) {
				Rectangle level1Rec = new Rectangle(Boss[i][j].getxAxis(), Boss[i][j].getyAxis(), 25, 25);
				if(bulletRec.intersects(level1Rec)) {
					Boss[i][j].setxAxis(Boss[i][j].getxAxis());
					bullet.setxAxis(-1000000);
					scoreboss += 10 ;
	}
				if(scoreboss == 300) Boss[i][j].setxAxis(1000000);  // set mau cho Boss
}
}
}
}
