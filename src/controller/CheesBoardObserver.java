package controller;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.model.ChessListener;

public class CheesBoardObserver implements ChessListener {

	private JPanel contener;
	private ImageIcon knightIcon;

	public JPanel getContener() {
		return contener;
	}

	public CheesBoardObserver(JPanel contener, ImageIcon knightIcon) {
		this.contener = contener;
		this.knightIcon = knightIcon;
	}

	@Override
	public void actionPerformed(boolean setUp,  int top, int left) {
		System.out.println(setUp);
		JPanel content = getContener();
		String localization = "(" + top + "," +left + ")";
		System.out.println(localization);
		if (setUp){
			for (Component component : content.getComponents()) {
				JButton button = (JButton) component;
				if (button.getName().equals(localization)){
					button.setIcon(knightIcon);
				}
			}
		} else {
			for (Component component : content.getComponents()) {
				JButton button = (JButton) component;
				if (button.getName().equals(localization)){
					button.setIcon(null);
				}
			}
		}
		
	}

}
