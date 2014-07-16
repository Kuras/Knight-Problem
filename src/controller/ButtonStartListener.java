/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.model.ChessBoard;

/**
 * @author Baraka
 *
 */
public class ButtonStartListener implements ActionListener {

	private ChessBoard model;

	public ButtonStartListener(ChessBoard model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Thread chessBoardThread = new Thread(model);
		chessBoardThread.start();
	}

}
