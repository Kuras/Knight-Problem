package applet;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.ButtonStartListener;
import controller.ChessBoardGridAWTAction;
import main.model.ChessBoard;
import view.window.ChessBoardGrid;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KnightsProblemApplet extends JApplet implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JPanel contentPane;
	
	@Override
	public void init() {
		super.init();
		
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("EditorPane.border"));
		contentPane.setLayout(new BorderLayout());		
		setContentPane(contentPane);
		
		ChessBoard model = new ChessBoard();
		ButtonStartListener listener = new ButtonStartListener (model);
		
		ImageIcon knightIcon = new ImageIcon(getClass().getResource("../fotos/knight.png"));
		
		ChessBoardGrid chessBoardGrid = new ChessBoardGrid(model, knightIcon);// set up observer relationship
		ChessBoardGridAWTAction chessBoardGridAWTAction = new ChessBoardGridAWTAction(chessBoardGrid);
		chessBoardGridAWTAction.addActionListener(this);
		
		btnNewButton = new JButton("Start");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(listener);
		contentPane.add(chessBoardGrid.getContener(),BorderLayout.CENTER);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 165));
		panel.setBackground(Color.darkGray);
		panel.add(btnNewButton);
		contentPane.add(panel,BorderLayout.WEST);
	}
	/**
	 * Create the applet.
	 */
	public KnightsProblemApplet() {
		super();
		
		setSize(1600, 1660);
		
		
		
//		add((new MyWindow()).getParent());
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyWindow frame = new MyWindow();
////					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		btnNewButton.setEnabled(true);

	}
	
	

}
