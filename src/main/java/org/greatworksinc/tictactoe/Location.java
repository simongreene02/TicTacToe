package org.greatworksinc.tictactoe;

public class Location {
	private final int x;
	private final int y;
	private Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public static Location with(int x, int y) {
		return new Location(x, y);
	}
}
