package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.window.ChessBoardGrid;
import main.model.Knight;

public class ButtonsListener implements MouseListener {

	private ChessBoardGrid chessBoardGrid;
	private ImageIcon knightIcon;

	public ButtonsListener(ChessBoardGrid chessBoardGrid, ImageIcon knightIcon) {
		this.chessBoardGrid = chessBoardGrid;
		this.knightIcon = knightIcon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton button = (JButton) e.getSource();
		String name = button.getName();
		String[] tabName = name.split(",");
		int top = Integer.parseInt(tabName[0].substring(1));
		int left = Integer.parseInt(tabName[1].substring(0, 1));
		chessBoardGrid.setKnight(new Knight(top, left));
		System.out.println("Pressed Mouse");
		button.setIcon(knightIcon);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component[] components = chessBoardGrid.getContener().getComponents();
		JButton button;
		for (Component component : components) {
			button = (JButton) component;
			button.removeMouseListener(this);
		}
		System.out.println("Released Mouse");
	}


}
