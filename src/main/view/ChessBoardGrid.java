package main.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.model.ChessBoard;
import main.model.Destination;
import main.model.Knight;

public class ChessBoardGrid extends ChessBoard implements Runnable {

	private JPanel contener;
	private MouseListener buttonListener;

	public ChessBoardGrid() {
		super();
		contener = new JPanel();
		contener.setLayout(new GridLayout(HEIGHT, WIDTH));
		JButton button;
		buttonListener = new ButtonListener(this);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				button = new JButton(" ");
				button.addMouseListener(buttonListener);
				button.setName("(" + i + "," + j + ")");
				contener.add(button);
			}
		}
	}

	public JPanel getContener() {
		return contener;
	}

	public MouseListener getButtonListener() {
		return buttonListener;
	}
	
	@Override
	public void setKnight(Knight knight) {
		super.setKnight(knight);
		Component[] components = getContener().getComponents();
		JButton button;
		String pusshedButton = "("+knight.getTop()+","+knight.getLeft()+")";
		for (Component component : components) {
			button = (JButton) component;
			if (pusshedButton.equals(button.getName())){// we think about button like on Data object
				button.setText("X");
			}
		}
		System.out.println("->");		
	}
	
	@Override
	public void moveBack(Knight knight, Destination destination) {
		Component[] components = getContener().getComponents();
		JButton button;
		String movedButton = "("+knight.getTop()+","+knight.getLeft()+")";
		for (Component component : components) {
			button = (JButton) component;
			if (movedButton.equals(button.getName())){
				button.setText(" ");
			}
		}
		super.moveBack(knight, destination);
		System.out.println("<-");
	}
	
	@Override
	public void show() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println(hasResolved());
	}

	
}
