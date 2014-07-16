package view.window.component;

import javax.swing.JButton;

import controller.ButtonStartListener;
import view.window.ButtonInterface;

public class MyButton extends JButton implements ButtonInterface {

	private static final long serialVersionUID = 1L;

	public MyButton() {
		super();
	}
	
	public MyButton(String name) {
		super(name);
	}

	@Override
	public void myClick() {
		super.doClick();
	}

	@Override
	public void addActionListener(ButtonStartListener listener) {
		super.addActionListener(listener);
	}
	
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
	}
	
}
