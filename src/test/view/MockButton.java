package test.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import main.model.ChessBoard;
import controller.ButtonStartListener;
import view.window.ButtonInterface;

public class MockButton implements ButtonInterface {

	public boolean enabled = false;
	public ArrayList<ButtonStartListener> listeners = new ArrayList<>();
	ChessBoard model = new ChessBoard();
	Thread chessBoardThread;
	private boolean hasListener = false;

	@Override
	public void myClick() {
		if (enabled && hasListener){
			chessBoardThread = new Thread(model);
			for (ButtonStartListener listener : listeners) {
//				listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "click acccction"));
				System.out.println("Send message to listener " + listener.hashCode());
			}
//			chessBoardThread.start();
		}
	}

	@Override
	public void setEnabled(boolean b) {
		this.enabled = b;
	}

	@Override
	public void addActionListener(ButtonStartListener listener) {
		listeners.add(listener);
		hasListener  = true;
	}

}
