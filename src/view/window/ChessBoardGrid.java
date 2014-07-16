package view.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ButtonsListener;
import controller.CheesBoardObserver;
import main.model.ChessBoard;
import main.model.Knight;

public class ChessBoardGrid{

	private JPanel contener;
	private ChessBoard chessBoard;

	public JPanel getContener() {
		return contener;
	}

	public ChessBoardGrid(ChessBoard chessBoard, ImageIcon knightIcon) {
		this.chessBoard = chessBoard;
		contener = new JPanel();
		contener.setLayout(new GridLayout(chessBoard.HEIGHT, chessBoard.WIDTH,1,1));
		contener.setSize(new Dimension(300, 300));
		contener.setBackground(Color.CYAN);
		JButton button;
		ButtonsListener buttonsListener = new ButtonsListener(this, knightIcon);
		for (int i = 0; i < chessBoard.HEIGHT; i++) {
			for (int j = 0; j < chessBoard.WIDTH; j++) {
				button = new JButton();
				button.addMouseListener(buttonsListener);
				button.setName("(" + i + "," + j + ")");
				contener.add(button);
			}
		}
		chessBoard.addListener(new CheesBoardObserver(contener, knightIcon));
	}

	public void setKnight(Knight knight) {
		chessBoard.setKnight(knight);
	}

		
}
