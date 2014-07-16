package main.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import main.view.ChessBoardAction;

public class Program extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private ChessBoardGrid chessBoard;
	private JButton button;

	public Program() {
		super("Knight's Problem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);
		
		chessBoard = new ChessBoardGrid();
//		chessBoard.addActionListener(this);
		ChessBoardAction chessBoardAction = new ChessBoardAction(chessBoard);
		chessBoardAction.addActionListener(this);
//		Thread thread = new Thread(chessBoardAction);
//		thread.start();
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		button = new JButton("Start");
		button.setEnabled(false);
		button.addActionListener(new ButtonStart());
		c.add(button);
		c.add(chessBoard.getContener());

	}

	class ButtonStart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Thread threadResolver = new Thread(chessBoard);
			threadResolver.start();
			System.out.println("Performed computaion associated with path found");
		}
	}
	
	public static void main(String[] args) {
		new Program();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("observer is going on");
		button.setEnabled(true);
	}
}
