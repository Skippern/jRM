package org.gimnechiske.jRM.gui;

import java.io.*;
import java.rmi.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import org.gimnechiske.jRM.*;

public class OpenGameDialog extends JFileChooser {
	private static final long serialVersionUID = 1L;
	public OpenGameDialog() throws IOException, ClassNotFoundException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"jRM Game File", "rmgame");
		setFileFilter(filter);
		int returnVal = showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = getSelectedFile();
			Game g = null;
			ObjectInputStream in = null;
			RMServer server = GamemasterApp.serverObj;
			try {
				FileInputStream stream = new FileInputStream(f);
				in = new ObjectInputStream(stream);
				while (true) {
					g = (Game) in.readObject();
				}

			} catch (FileNotFoundException e) {
				System.out.println("[GM] ERROR: Reading Game File");
				e.printStackTrace();
			} catch (EOFException e) {
			}
			in.close();
			System.out.println("[GM] Game file loaded");
			g.gameMaster = GamemasterApp.myGamemasterObject;
			g.playerList = null;
			GamemasterApp.myGameObject = g;
			try {
				System.out.println("[GM] Registering game " + g.getName() +
						" in server");
				server.registerGame(g);
			} catch (RemoteException e) {
				System.out.println("[GM] ERROR: Cannot register game in server");
				e.printStackTrace();
			}
		}
		GamemasterWindow.gameMenuStatus();
	}
}
