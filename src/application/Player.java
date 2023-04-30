package application;

public class Player {
    private int x;
    private int y;
    private int size = 20;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y -= 10;
    }

    public void moveDown() {
        y += 10;
    }

    public void moveLeft() {
        x -= 10;
    }

    public void moveRight() {
        x += 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}