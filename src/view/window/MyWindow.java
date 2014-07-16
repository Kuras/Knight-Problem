package view.window;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import controller.ButtonStartListener;
import controller.ChessBoardGridAWTAction;
import main.model.ChessBoard;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.UIManager;

public class MyWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4_536_321_076_736_277_313L;
	private ButtonInterface btn;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param button 
	 */
	public MyWindow(ButtonInterface button) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("EditorPane.border"));
		contentPane.setLayout(new BorderLayout());		
		setContentPane(contentPane);
		
		ChessBoard model = new ChessBoard();
		ButtonStartListener listener = new ButtonStartListener (model);
		
		ImageIcon knightIcon = new ImageIcon(getClass().getResource("../../fotos/knight.png"));
		
		ChessBoardGrid chessBoardGrid = new ChessBoardGrid(model, knightIcon);// set up observer relationship
		ChessBoardGridAWTAction chessBoardGridAWTAction = new ChessBoardGridAWTAction(chessBoardGrid);
		chessBoardGridAWTAction.addActionListener(this);
		
		btn = button;
		btn.setEnabled(false);
		btn.addActionListener(listener);
		contentPane.add(chessBoardGrid.getContener(),BorderLayout.CENTER);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 165));
		panel.setBackground(Color.darkGray);
		panel.add((JButton) btn);
		contentPane.add(panel,BorderLayout.WEST);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		btn.setEnabled(true);
	}

}
