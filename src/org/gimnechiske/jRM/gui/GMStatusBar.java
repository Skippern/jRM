package org.gimnechiske.jRM.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GMStatusBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel statusLamp;
	public GMStatusBar() {
		setLayout(new FlowLayout());
		setAlignmentX(FlowLayout.LEFT);
		Border border = new SoftBevelBorder(BevelBorder.RAISED);
		setBorder(border);
		
		add(statusLamp = new serverStatusLamp());
		
		add(new JLabel("Test"));
		add(new JLabel("xxx"));
	}
	
	private class serverStatusLamp extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics panel) {
			super.paintComponent(panel);
			setBackground(Color.gray);
			setForeground(Color.blue);
			panel.fillOval(0, 0, 9, 9);

			updateStatusLamp();
		}
		
	}
	
	private void updateStatusLamp() {
		int connectionStatus = 1;
		// test connection
		
		if (connectionStatus == 1) {
			statusLamp.setForeground(Color.green);			
		}
		else if (connectionStatus == 0) {
			statusLamp.setForeground(Color.yellow);			
		}
		else if (connectionStatus == -1) {
			statusLamp.setForeground(Color.red);			
		}
		else statusLamp.setForeground(Color.lightGray);
	}
}
