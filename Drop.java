package shootfeedFish;


public class Drop extends Thread{ 
	
	Level1design g1;
	Level1[][] level1;
	
	public Drop(Level1design g1, Level1[][] level1) {
		super();
		this.g1 = g1;
		this.level1 = level1;
	}
	
	public void run() {
		while(level1[0][0].getyAxis() < 600) {
		for(int i = 0; i < level1.length; i++) {
			for(int j = 0; j < level1[i].length; j++) {
				level1[i][j].move();
			}
		}
		try{ 
			Thread.sleep(10);
			
		}catch(Exception e) {System.out.println(e);}

		g1.repaint();
	}
}
}
