package shootfeedFish;


public class Drop3 extends Thread{ 
		Level3design g1;
		Level3[][] level3;
		Level3[][] Boss;
		public Drop3(Level3design g1, Level3[][] level3) {
			super();
			this.g1 = g1;
			this.level3 = level3;
		} 

		
		
		public void run() {
			while(level3[0][0].getyAxis() < 800) {
			for(int i = 0; i < level3.length; i++) {
				for(int j = 0; j < level3[i].length; j++) {
					level3[i][j].setyAxis(level3[i][j].getyAxis() + 15);
					System.out.println(level3[i][j].getyAxis());
				}
			}
			try{ 
				Thread.sleep(750);
				
			}catch(Exception e) {System.out.println(e);}

			g1.repaint();
		}
			while(Boss[0][0].getyAxis() < 990) {
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

