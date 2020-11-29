package shootfeedFish;

public class Drop2 extends Thread{ 
	
	Level2design g1;
	Level2[][] level2;
	Level2[][] Boss;
	public Drop2(Level2design g1, Level2[][] level2) {
		super();
		this.g1 = g1;
		this.level2 = level2;
	} 

	
	
	public void run() {
		while(level2[0][0].getyAxis() < 800) {
		for(int i = 0; i < level2.length; i++) {
			for(int j = 0; j < level2[i].length; j++) {
				level2[i][j].setyAxis(level2[i][j].getyAxis() + 15);
				System.out.println(level2[i][j].getyAxis());
			}
		}
		try{ 
			Thread.sleep(750);
			
		}catch(Exception e) {System.out.println(e);}

		g1.repaint();
	}
		while(Boss[0][0].getyAxis() < 790) {
		for(int i = 0; i < Boss.length; i++) {
			for(int j = 0; j < Boss[i].length; j++) {
				Boss[i][j].setyAxis(Boss[i][j].getyAxis() + 15);
				System.out.println(Boss[i][j].getyAxis());
			}
		}
		try{ 
			Thread.sleep(800);
			
		}catch(Exception e) {System.out.println(e);}

		g1.repaint(); 
	}
}
}
