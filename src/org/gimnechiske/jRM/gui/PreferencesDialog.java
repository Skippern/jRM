package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.gimnechiske.jRM.*;

public class PreferencesDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lGMname = new JLabel("Name");
	private JTextField tf1 = new JTextField(20);
	private JLabel lGMxxx = new JLabel("xxx");
	private JTextField tf2 = new JTextField(20);
	private JButton apply = new JButton("Apply");
	private JButton cancel = new JButton("Cancel");
	private Gamemaster gm = GamemasterApp.getGamemaster();

	public PreferencesDialog() {
		ActionListener l = new ButtonListener();
		setTitle("Preferences");
		setAlwaysOnTop(true);
		setAutoRequestFocus(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		add(lGMname);
		tf1.setText(gm.getName());
		add(tf1);
		add(lGMxxx);
		add(tf2);
		apply.addActionListener(l);
		add(apply);
		cancel.addActionListener(l);
		add(cancel);
		pack();
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Cancel") {
				setVisible(false);
			}
			else if (e.getActionCommand() == "Apply") {
				String gmName = tf1.getText();
				gm.setName(gmName);
				
				/* End by saving preferences */
				GamemasterApp.savePrefs();
			}
		}
		
	}
}
