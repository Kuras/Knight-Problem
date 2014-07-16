package main.model;

public enum Destination {
	NONE, TOP_RIGHT(-2, 1), LEFT_TOP(-1, -2), LEFT_DOWN(1, -2), RIGHT_TOP(-1, 2), RIGHT_DOWN(
			1, 2), DOWN_LEFT(2, -1), DOWN_RIGHT(2, 1), TOP_LEFT(-2, -1);
	private int top;
	private int left;

	private Destination(int top, int left) {
		setTop(top);
		setLeft(left);
	}

	private Destination() {
		setTop(0);
		setLeft(0);
	}

	private void setTop(int top) {
		this.top = top;
	}

	private void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}

	public boolean hasNext() {
		if (ordinal() + 1 < Destination.values().length) {
			return true;
		} else {
			return false;
		}
	}

	public Destination next() {
		Destination newDestination = Destination.values()[ordinal() + 1];
		return newDestination;
	}

}
