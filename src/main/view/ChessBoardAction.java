package main.view;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ChessBoardAction{
	
	ArrayList<ActionListener> listenerList = new ArrayList<>();

	public ChessBoardAction(main.view.ChessBoardGrid boardGrid) {
		long eventMask = AWTEvent.FOCUS_EVENT_MASK;
		Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener(){
		    
			public void eventDispatched(AWTEvent e)
		    {
		        if(e.getSource() instanceof JButton){
		        	if(((JButton)e.getSource()).getText() == "X")
		        		notifyListeners();
		        	System.out.println("is a button");
		        }
		    }
		}, eventMask);		
	}


	public void addActionListener(ActionListener acListener) {
		listenerList.add(acListener);
	}
	
	public void removeActionListener(ActionListener acListener) {
		listenerList.remove(acListener);
	}
	
	private void notifyListeners() {
		System.out.println("powiadomiono all");
	    for (ActionListener listener : listenerList) {
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "my own action"));
		}
	  }
}
