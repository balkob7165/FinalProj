package application;

public class Player {

	private int xpos;
	private int ypos;
	
	public Player() {
		xpos=0;
		ypos=0;
	}
	
	public void moveUp() {
		ypos--;
	}

	public void moveDown() {
		ypos++;
	}

	public void moveLeft() {
		xpos--;
	}

	public void moveRight() {
		xpos++;
	}
	
	public int getY() {
		return ypos;
	}
	
	public int getX() {
		return xpos;
	}
}
