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
	public static Location with(String input) {
		// TODO Auto-generated method stub
		String[] result = input.split(",");
		if (result.length == 2) {
			Integer.parseInt(result[0]);
		}
		return null;
	}
}
