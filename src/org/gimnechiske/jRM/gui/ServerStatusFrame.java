package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.rmi.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import org.gimnechiske.jRM.*;

/**
 * 
 * @author Aun Johnsen
 * 
 * This is a server status frame, that should auto-update information
 * about the connected server.
 */
public class ServerStatusFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private RMServer server = GamemasterApp.serverObj;
	private JLabel serverName = new JLabel("Name", JLabel.RIGHT);
	private JLabel gm = new JLabel("0", JLabel.RIGHT);
	private JLabel players = new JLabel("0", JLabel.RIGHT);
	private JLabel games = new JLabel("0", JLabel.RIGHT);
	private int status;
	private JLabel statusLabel = new JLabel("unknown", JLabel.RIGHT);
	
	public ServerStatusFrame() throws RemoteException, Exception {
		setMaximizable(false);
		setResizable(false);
		setClosable(false);
		setIconifiable(true);
		setTitle("Server Status");
		setVisible(true);
		setLayout(new FlowLayout());
		JPanel  serverPanel = new ServerStatusPanel();
		add(serverPanel);
		pack();
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					updateStatus();
				} catch (RemoteException e) {
					System.out.println("[GM] ERROR: Remote Exception in Server Status Frame");
				} catch (InterruptedException e) {
					System.out.println("[GM] ERROR: Interrupted Exception in Server Status Frame");
				}
			}
		}, 0, 5, TimeUnit.SECONDS);
	}
	

	private class ServerStatusPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private ServerStatusPanel() throws RemoteException, Exception {
			setLayout(new GridLayout(5,2));
			updateStatus();
			add(new JLabel("Server name:"));
			add(serverName);
			add(new JLabel("Gamemasters:"));
			add(gm);
			add(new JLabel("Players:"));
			add(players);
			add(new JLabel("Games:"));
			add(games);
			add(new JLabel("Status:"));
			add(statusLabel);
			
		}
	}
	
	public synchronized void updateStatus() throws RemoteException, InterruptedException {
		try {
			if (server == null) server = GamemasterApp.getServer();
			if (server != null) {
				serverName.setText(server.getName());
				gm.setText(String.valueOf(server.countGM()));
				players.setText(String.valueOf(server.countPlayers()));
				games.setText(String.valueOf(server.countGames()));
				status = 1;
			}
			else {
				serverName.setText("NULL");
				gm.setText("N/A");
				players.setText("N/A");
				games.setText("N/A");
				status = 0;
			}
			switch (status) {
			case 0:
				statusLabel.setText("Offline");
				statusLabel.setForeground(Color.RED);
				break;
			case 1:
				statusLabel.setText("Online");
				statusLabel.setForeground(Color.GREEN);
				break;
			case 2:
				statusLabel.setText("Slow");
				statusLabel.setForeground(Color.YELLOW);
				break;
			default:
				statusLabel.setText("unknown");
				statusLabel.setForeground(Color.GRAY);
				break;
			}
		} catch (RemoteException e) {
			statusLabel.setText("Offline");
			statusLabel.setForeground(Color.RED);
			gm.setText("0");
			players.setText("0");
			games.setText("0");
			serverName.setForeground(Color.GRAY);
		}
	}
}
