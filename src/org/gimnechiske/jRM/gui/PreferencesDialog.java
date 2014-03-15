package org.gimnechiske.jRM.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.gimnechiske.jRM.Gamemaster;
import org.gimnechiske.jRM.GamemasterApp;

public class PreferencesDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JLabel lGMname = new JLabel("Name");
	private final JTextField tf1 = new JTextField(20);
	private final JLabel lGMxxx = new JLabel("xxx");
	private final JTextField tf2 = new JTextField(20);
	private final JButton apply = new JButton("Apply");
	private final JButton cancel = new JButton("Cancel");
	private final Gamemaster gm = GamemasterApp.getGamemaster();

	public PreferencesDialog() {
		ActionListener l = new ButtonListener();
		setTitle("Preferences");
		setAlwaysOnTop(true);
		requestFocus(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(3, 2));
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
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Cancel") {
				setVisible(false);
			} else if (e.getActionCommand() == "Apply") {
				String gmName = tf1.getText();
				gm.setName(gmName);

				/* End by saving preferences */
				GamemasterApp.savePrefs();
			}
		}

	}
}
