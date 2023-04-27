package application;

import java.util.Random;

public class Map {
	
	private boolean coin = false;
	private boolean tree = false;
	private boolean npc = false;
	
	public Map(boolean coin, boolean tree, boolean npc) {
		coin = this.coin;
		tree = this.tree;
		npc = this.npc;
	}
	
	public Map() {
		generate();
	}
	
	public void generate() {
		Random rand = new Random();
		int odds = rand.nextInt(100);
		
		if(odds>50&&odds<=70) {
			tree = true;
		}
		if(odds>70&&odds<=80) {
			coin = true;
		}
		if(odds>80&&odds<=90) {
			npc = true;
		}
	}
	

}
