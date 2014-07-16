/**
 * 
 */


import javax.swing.JButton;

/**
 * @author Baraka
 *
 */
public class BoardListener implements BoardListenerInterface {

	private JButton button;

	public BoardListener(JButton btnNewButton) {
		this.button = btnNewButton;
	}

	@Override
	public void performedAction() {
		button.setEnabled(true);
	}

}
