package main.model;

import java.util.ArrayList;


public class ChessBoard implements Runnable{

	private static final int NONE_CHECKED_SQUARE = 0;
	public final int HEIGHT = 5;
	public final int WIDTH = 5;
	
	private boolean[][] board = new boolean[HEIGHT][WIDTH];
	private Knight knight;
	private int conterFixedFields;
	private ArrayList<ChessListener> listeners;

	public ChessBoard() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				board[i][j] = false;
			}
		}
		conterFixedFields = NONE_CHECKED_SQUARE;
		listeners = new ArrayList<>();
	}

	public void setKnight(Knight knight) {
		this.knight = knight;
		assert (knight.getTop() < HEIGHT);
		assert (knight.getLeft() < WIDTH);
		assert (knight.getTop() >= 0);
		assert (knight.getLeft() >= 0);
		assert (conterFixedFields <= HEIGHT * WIDTH);
		notyfyAll(true, knight);
		conterFixedFields++;
		board[knight.getTop()][knight.getLeft()] = true;
	}

	public boolean hasResolved() {
		boolean solved = false;
		Destination destination = Destination.NONE;

		if (isFull()) {
			solved = true;
		} else {			
			while (destination.hasNext() && !solved) {
				destination = destination.next();
				if (knight.nextMoveLegal(this, destination)) {
					knight.move(destination);
					setKnight(knight);
					show();
					if (hasResolved()) {						
						solved = true;
					} else {
						moveBack(knight, destination);						
					}					
				}
			}
		}
		return solved;
	}

	public void moveBack(Knight knight, Destination destination) {
		assert (conterFixedFields > 0);
		conterFixedFields--;
		notyfyAll(false, knight);
		board[knight.getTop()][knight.getLeft()] = false;
		knight.moveBack(this, destination);
	}

	private void notyfyAll(boolean b, Knight knight) {
		for (ChessListener listener : listeners) {
			listener.actionPerformed(b,knight.getTop(),knight.getLeft());
		}
	}

	public boolean isFull() {
		return conterFixedFields == WIDTH * HEIGHT;
	}

	public boolean fieldFulled(Knight knight) {
		return board[knight.getTop()][knight.getLeft()];
	}

	public boolean fieldFulled(int top, int left) {
		return board[top][left];
	}

	public void show() {
		System.out.println();
		System.out.println();
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		for (int i = 0; i < HEIGHT; i++) {
			System.out.println();
			for (int j = 0; j < WIDTH; j++) {
				if (fieldFulled(i, j)){
					System.out.print(" X ");
				} else {
					System.out.print(" _ ");
				}
				
			}

		}
		System.out.println();
	}

	public void addListener(ChessListener chessListener) {
		listeners.add(chessListener);
	}
	
	@Override
	public void run() {
		System.out.println(hasResolved());
	}

}
