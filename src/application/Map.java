package application;

import java.util.Random;

public class Map {
	
	private boolean coin = false;
	private boolean tree = false;
	private boolean npc = false;
	
	public Map(boolean coin, boolean tree, boolean npc) {//new map data packet with predetermined attributes
		coin = this.coin;
		tree = this.tree;
		npc = this.npc;
	}
	
	public boolean hasItem() {
		if(coin||tree||npc) {
			return true;
		}
		else return false;
	}
	
	public boolean coin() {
		return coin;
	}
	
	public boolean tree() {
		return tree;
	}
	
	public boolean npc() {
		return npc;
	}
	
	public Map() {//creates new map data packet with random attributes
		generate();
	}
	
	public void generate() {
		Random rand = new Random();
		int odds = rand.nextInt(100);//one number generated to fulfill only 1 if statement so only 1 entity is in the space
		
		if(odds>0&&odds<=15) {//15% chance of tree
			tree = true;
		}
		if(odds>15&&odds<=25) {//10% chance of coin
			coin = true;
		}
		if(odds>25&&odds<=30) {//5% chance of npc
			npc = true;
		}
	}
	
	public String toString() {
		if(hasItem()) {
			if(coin()) {
				return "Coin";
			}
			if(tree()) {
				return "Tree";
			}
			else return "NPC";
		}
		else return "Empty";
	}
	

}
