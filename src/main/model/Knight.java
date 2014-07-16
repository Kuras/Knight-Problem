package main.model;


public class Knight {

	private int left;
	private int top;

	public Knight(int top, int left) {
		setLeft(left);
		setTop(top);
	}

	public Knight() {
		new Knight(0,0);
	}

	public int getLeft() {
		return left;
	}

	public int getTop() {
		return top;
	}

	public boolean nextMoveLegal(ChessBoard chessBoard, Destination destination) {
		boolean isLegal = false;
		int possibleTop = getTop() + destination.getTop();
		int possibleLeft= getLeft()+ destination.getLeft();
		if ((possibleTop  < chessBoard.HEIGHT) && (possibleLeft < chessBoard.WIDTH)){
			if ((possibleTop >= 0) && (possibleLeft >= 0)){
				if (!chessBoard.fieldFulled(possibleTop,possibleLeft)){
					isLegal = true;
				} 
			}
		}
		return isLegal ;
	}

	public void move(Destination destination) {
		int newTop = getTop() + destination.getTop();
		setTop(newTop);
		int newLeft = getLeft() + destination.getLeft();
		setLeft(newLeft ); 
	}

	public void moveBack(ChessBoard cb, Destination destination) {
		int newTop = getTop() - (destination.getTop());
		int newLeft = getLeft() - (destination.getLeft());
		if (newTop >= 0 && newLeft >= 0){
			if (newTop < cb.HEIGHT && newLeft < cb.WIDTH){
				setTop(newTop);
				setLeft(newLeft);
			}
		}
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void setLeft(int left) {
		this.left = left;
	}
	
	public String toString(){
		return "( " + top + ", " + left + " )";
	}

}
