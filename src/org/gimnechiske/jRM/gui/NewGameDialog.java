package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.awt.event.*;

import java.rmi.RemoteException;

import javax.swing.*;
import org.gimnechiske.jRM.*;

public class NewGameDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextField tf1 = new JTextField(12);
	Gamemaster myGM;
	JTextField tf3 = new JTextField(12);
	JTextField tf4_1 = new JTextField(3);
	JTextField tf4_2 = new JTextField(3);
	JComboBox<String> cb5 = new JComboBox<>();
	JComboBox<String> cb6 = new JComboBox<>();
	JComboBox<String> cb7 = new JComboBox<>();
	JComboBox<String> cb8 = new JComboBox<>();
	
	public NewGameDialog(Gamemaster gm) {
		myGM = gm;
		GridBagLayout l = new GridBagLayout();
		setLayout(l);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.weightx = 0.5;
		c.weighty = 0.5;
		/* Fields and labels */
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label1 = new JLabel("Game Name:");
		add(label1,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		add(tf1,c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label2 = new JLabel("Gamemaster:");
		add(label2,c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		JTextField tf2 = new JTextField(12);
		tf2.setEditable(false);
		tf2.setFocusable(false);
		tf2.setText(gm.getName());
		add(tf2,c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label3 = new JLabel("World Name:");
		add(label3,c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		add(tf3,c);
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label4_1 = new JLabel("Players:");
		add(label4_1);
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.WEST;
		// Make field only accept numbers
		tf4_1.setText("1");
		add(tf4_1);
		c.gridx = 2;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		JLabel label4_2 = new JLabel("-");
		add(label4_2,c);
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.EAST;
		// Make field only accept numbers
		tf4_2.setText("8");
		add(tf4_2,c);
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label5 = new JLabel("Magic level:");
		add(label5,c);
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.WEST;
		cb5.addItem("High Magic");
		cb5.addItem("Medium Magic");
		cb5.addItem("Low Magic");
		cb5.addItem("No Magic");
		add(cb5,c);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label6 = new JLabel("Hero level:");
		add(label6,c);
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.WEST;
		cb6.setEditable(false);
		cb6.addItem("Common");
		cb6.addItem("Heroic");
		cb6.addItem("Legendary");
		cb6.addItem("Fantastic");
		cb6.addItem("Superheroic");
		cb6.addItem("Devine Intervention");
		add(cb6,c);
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label7 = new JLabel("Technology level:");
		add(label7,c);
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.WEST;
		cb7.setEditable(false);
		cb7.addItem("Stone Age");
		cb7.addItem("Copper Age");
		cb7.addItem("Bronze Age");
		cb7.addItem("Iron Age");
		cb7.addItem("Age of Empire");
		cb7.addItem("Middle Ages");
		cb7.addItem("Renaissance");
		cb7.addItem("Age of Reason");
		cb7.addItem("Industrial Revolution");
		cb7.addItem("Age of Steam");
		cb7.addItem("Electric Age");
		cb7.addItem("Atomic Age");
		cb7.addItem("Information Age");
		cb7.addItem("Space Age");
		add(cb7,c);
		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		JLabel label8 = new JLabel("Setting Type");
		add(label8,c);
		c.gridx = 1;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.VERTICAL;
		c.anchor = GridBagConstraints.WEST;
		cb8.setEditable(false);
		cb8.addItem("Fantasy");
		cb8.addItem("High Fantasy");
		cb8.addItem("Science Fiction");
		cb8.addItem("Steam Punk");
		cb8.addItem("Pulp");
		cb8.addItem("Post Apocalyptic");
		cb8.addItem("Cartoon");
		cb8.addItem("Horror");
		cb8.addItem("Crime");
		cb8.addItem("Hack'n'Slash");
		add(cb8,c);
		
		// Buttons
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 4;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		JPanel buttons = new ButtonPane(this);
		add(buttons,c);
		
		pack();
	}
	
	private class ButtonPane extends JPanel {
		private static final long serialVersionUID = 1L;
		public Dialog parent;
		private ButtonPane(Dialog parentDialog) {
			parent = parentDialog;
			JButton ok = new JButton("Create Game");
			JButton cancel = new JButton("Cancel");
			
			ok.addActionListener(new ButtonListener());
			ok.setMnemonic('c');
			cancel.addActionListener(new ButtonListener());
			
			add(ok);
			add(cancel);
			pack();
		}
		
		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (cmd == "Cancel") {
					System.out.println("[GM] New Game: Canceled");
					parent.setVisible(false);
				} else {
					System.out.println("[GM] New Game: Create new game");
					String gamename = tf1.getText();
					String worldname = tf3.getText();
					// tf4_1 and tf4_2 should only accept numerical
					int minPlayers = Integer.valueOf(tf4_1.getText());
					int maxPlayers = Integer.valueOf(tf4_2.getText());
					String magicLevel = (String) cb5.getSelectedItem();
					String heroLevel = (String) cb6.getSelectedItem();
					String techLevel = (String) cb7.getSelectedItem();
					String settingType = (String) cb8.getSelectedItem();
					boolean error = false;
					if (gamename.length() == 0) {
						error = true;
						tf1.setBackground(Color.red);
					}
					else tf1.setBackground(Color.green);
					if (worldname.length() == 0) {
						error = true;
						tf3.setBackground(Color.red);
					}
					else tf3.setBackground(Color.green);
					if (minPlayers < 1) {
						error = true;
						tf4_1.setBackground(Color.red);
					}
					else tf4_1.setBackground(Color.green);
					if (maxPlayers < minPlayers) {
						error = true;
						tf4_2.setBackground(Color.red);
					}
					else tf4_2.setBackground(Color.green);
					
					if (error) {
						System.out.println("[GM] New Game: Error, try correcting your fields");
						JOptionPane.showMessageDialog(null, 
								"An error in input data, edit any highlighted fields and try again.", 
								"Input error!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Game g = new Game(myGM, gamename);
						g.setWorld(worldname);
						g.setMinPlayers(minPlayers);
						g.setMaxPlayers(maxPlayers);
						g.setMagic(magicLevel);
						g.setHero(heroLevel);
						g.setTechnology(techLevel);
						g.setSetting(settingType);
					
						// put the game object into the server and register it
						// so that it becomes available for players
						try {
							System.out.println("[GM] Registering game in server");
							GamemasterApp.serverObj.registerGame(g);
							GamemasterApp.setGame(g);
							parent.setVisible(false);
							GamemasterWindow.gameMenuStatus();
						} catch (RemoteException e1) {
							System.out.println("[GM] ERROR: Cannot register game!");
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, 
									"ERROR: Cannot register game!",
									"Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
	}
}
