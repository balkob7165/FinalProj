package application;

import java.util.Random;

public class Enemy {
	private int x;
	private int y;

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void enemyMove() {
		Random random = new Random();
		 int dx = random.nextInt(3) - 1;
	     int dy = random.nextInt(3) - 1;
	     x += dx;
	     y += dy;
	}
	
	public int getXCoord() {
		return x;
	}
	
	public int getYCoord() {
		return y;
	}
}
