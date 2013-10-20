package org.gimnechiske.jRM;

import java.rmi.*;

import org.gimnechiske.jRM.gui.*;

import java.text.*;
import java.util.*;
import java.util.prefs.*;

import static javax.swing.JOptionPane.*;

public class GamemasterApp {
	public static RMServer serverObj;
	static String serverHost;
	public static Gamemaster myGamemasterObject;
	public static Game myGameObject;
	private static Preferences p = Preferences.userRoot().node("jRM").node("GamemasterApp");
	private static String gmName = "GM Name";
	private static GamemasterWindow window;
	public static ArrayList<Message> gmMessageQueue = new ArrayList<>();
	public static ArrayList<Message> gameMessageQueue = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		loadPrefs();
		window = new GamemasterWindow(myGamemasterObject, serverObj);
		window.setVisible(true);
	}
	
	public static void savePrefs() {
		System.out.print("[GM] Saving preferences: ");
		p.put(gmName, myGamemasterObject.getName());
		System.out.println("Saved!");
	}
	public static void loadPrefs() {
		System.out.print("[GM] Loading preferences: ");
		if (myGamemasterObject == null) myGamemasterObject = new Gamemaster();
		if (myGamemasterObject == null) System.out.println("[GM] ERROR: Still no gamemaster object!!!!");
		myGamemasterObject.setName(p.get(gmName, "Anonymus"));
		System.out.println("Loaded!");
	}
	
	public static void connectServer() throws Exception {
		final String serverName = "jRMServer";
		if (serverObj != null) {
			// Server exists/connected
			showMessageDialog(null, "You are already connected, if this problem persists, try exiting the program and connect again.");
			System.out.println("[GM] ERROR: Server already connected!");
		}
		else {
			try {
				serverHost = showInputDialog(null, "Host: ");
				String serverUrl = "rmi://" + serverHost + "/" + serverName;
				serverObj = (RMServer) Naming.lookup(serverUrl);
				System.out.println("[GM] Connected to " + serverHost + ": " +
						serverObj.getName());
				window.gmChat.setTitle("Chat: " + serverObj.getName());
				window.gmChat.send.setEnabled(true);
			} catch (Exception e) {
				System.out.println("[GM] ERROR: Cannot connect to " + serverHost + "!");
				e.printStackTrace();
			}
		}
		if (myGamemasterObject != null) {
			registerGamemaster(myGamemasterObject);
		}
		else {
			System.out.println("[GM] No Gamemaster to register in server");
		}
	}
	public synchronized static void registerGamemaster(Gamemaster gm) throws Exception {
		System.out.println("[GM] Creating Gamemaster object!");
		myGamemasterObject = gm;
		if (serverObj == null) {
			System.out.println("[GM] Trying to register Gamemaster without being connected to server");
		} else {
			System.out.print("[GM] Registering Gamemaster in server: ");
			try {
				serverObj.registerGM(myGamemasterObject);
				System.out.println("Done");
			} catch (RemoteException e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}
		}
	}
	
	public static final synchronized void setGamemaster(Gamemaster gm) {
		myGamemasterObject = gm;
	}
	public static final synchronized void setGame(Game g) {
		myGameObject = g;
	}
	public static final synchronized Game getGame() {
		return myGameObject;
	}
	public static final synchronized String getHostname() {
		return serverHost;
	}
	public static final synchronized RMServer getServer() {
		return serverObj;
	}
	public static final synchronized  Gamemaster getGamemaster() {
		return myGamemasterObject;
	}
	public static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("dd/HH:mm:ss z ");
		return x.format(now);
	}
	
	public static synchronized void getServerChatMessages() {
		if (serverObj == null) return;
		try {
			System.out.println("[GM] Getting messages from server.");
//			gmMessageQueue = serverObj.getGamemaster(myGamemasterObject.getName()).getMessages();
//			gameMessageQueue = serverObj.getGame(myGameObject.getName()).getMessages();
			System.out.println("[GM] " + gmMessageQueue.size() + " messages in GM queue");
		} catch (Exception e) {
			System.out.println("[GM] Get Server Chat Messages failed.");
		}
	}
}
