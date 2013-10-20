package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.rmi.*;
import javax.swing.*;
import org.gimnechiske.jRM.*;

/**
 * 
 * @author Aun Johnsen
 * 
 * This is a server status frame, that should auto-update information
 * about the connected server.
 */
public class GameChatFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private RMServer server;
	private Game myGame;
	
	public GameChatFrame() throws RemoteException, Exception {
		setMaximizable(true);
		setResizable(true);
		setClosable(false);
		setIconifiable(true);
		setTitle(myGame.getName() + ": Chat");
		setVisible(true);
		setLayout(new FlowLayout());
		pack();
	}
	
	public void setServer(RMServer server) {
		this.server = server;
	}
	public void setGame(Game myGame) {
		this.myGame = myGame;
	}
	public RMServer getServer() {
		return server;
	}
	public Game getGame() {
		return myGame;
	}
}
