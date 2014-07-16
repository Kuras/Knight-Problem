package view.window;

import controller.ButtonStartListener;

public interface ButtonInterface {

	void myClick();

	void setEnabled(boolean b);

	void addActionListener(ButtonStartListener listener);
}
