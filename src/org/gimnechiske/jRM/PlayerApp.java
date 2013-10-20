package org.gimnechiske.jRM;

import static javax.swing.JOptionPane.*;

import java.rmi.*;
import java.text.*;
import java.util.*;
import java.util.prefs.*;

public class PlayerApp {
	static RMServer serverObj;
	static String serverHost;
	static Player myPlayerObject;
	private static Preferences p = Preferences.userRoot().node("jRM").node("PlayerApp");
	static String pName = "Player Name";

	public static void main(String[] args) throws Exception {
		loadPrefs();
	}
	
	public static void savePrefs() throws RemoteException {
		System.out.println("[Player] Saving preferences");
		p.put(pName, myPlayerObject.getName());
	}
	public static void loadPrefs() throws RemoteException {
		System.out.println("[Server] Loading preferences");
		if (myPlayerObject == null) myPlayerObject = new Player();
		if (myPlayerObject == null) System.out.println("[Player] ERROR: Still no player object!!!!");
		myPlayerObject.setName(p.get(pName, "Anonymus"));
	}

	private static void connectServer() throws Exception {
		final String serverName = "jRMServer";
		if (serverObj != null) {
			// Server exists/connected
			System.out.println("[Player] ERROR: Server already connected!");
		}
		else {
			try {
				serverHost = showInputDialog(null, "Host: ");
				String serverUrl = "rmi://" + serverHost + "/" + serverName;
				serverObj = (RMServer) Naming.lookup(serverUrl);
				System.out.println("[Player] Connected to " + serverHost + ": " +
						serverObj.getName());
			} catch (Exception e) {
				System.out.println("[Player] ERROR: Cannot connect to " + serverHost + "!");
				e.printStackTrace();
			}
		}
		if (myPlayerObject != null) {
			System.out.println("[Player] ERROR: Player object already " +
					"registered, do nothing.");
		}
		else {
		}
	}
	private synchronized static void registerPlayer() {
		System.out.print("[Player] Registering Player in server: ");
		try {
			serverObj.registerPlayer(myPlayerObject);
			System.out.println("Done");
		} catch (RemoteException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	public static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("dd/HH:mm:ss z ");
		return x.format(now);
	}
}
