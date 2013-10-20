package org.gimnechiske.jRM;
/**
 * 
 * @author Aun Johnsen
 *
 */
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.text.*;
import java.util.*;
import java.util.prefs.Preferences;

import org.gimnechiske.jRM.lib.RMSystem;

public class ServerApp implements Serializable {
	private static final long serialVersionUID = 1L;
	static RMServer serverObject;
	static final int port = 1099;
	private static Preferences p = Preferences.userRoot().node("jRM").node("ServerApp");
	static String sName = "Server Name";

	public static void main(String[] args) throws Exception {
		try {
			LocateRegistry.createRegistry(port);
			System.out.println(now()+"[Server] Created Server connection on RMI port: " + port);
		} catch (Exception e) {
			System.out.println(now()+"[Server] RMI-Registry already open:" + e);
			e.printStackTrace();
		}
		String servername = "jRMServer";
		serverObject = new RMServerImpl();
		loadPrefs();
		Naming.rebind(servername, serverObject);
		System.out.println(now()+"[Server] Server bound, listening for connections on \"" +
				servername + "\" ... ");
		System.out.println(now()+"[Server] Server known as '" +
				serverObject.getName() + "'");
		
		InputStreamReader consolReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(consolReader);
		while (true) {
			String cmd = null;
			String arg = null;
			System.out.print("> ");
			cmd = reader.readLine();
			cmd = cmd.trim();
			/* split cmd at first blank, cmd should only be first word
			 * while the rest is gathered as argument (how to treat arguments
			 * are decided by cmd
			 */
			int pos = cmd.indexOf(" ");
			if (pos > 0) {
				arg = cmd.substring(pos);
				arg = arg.trim();
				cmd = cmd.substring(0, pos);
			}
			else arg = null;
			
			cmd = cmd.toLowerCase();
			switch (cmd) {
			case "":
				break;
			case "?":
				printHelp();
				break;
			case "shutdown":
			case "exit":
				serverShutdown(arg);
				break;
			case "list":
			case "ls":
			case "who":
				printLists(arg);
				break;
			case "set":
				setVariable(arg);
				break;
			case "say":
				serverObject.broadcast(RMSystem.MESSAGE_SERVER, "Server", arg);
				break;
			case "save":
				savePrefs();
				break;
			default:
				System.out.println(now()+"[Server] ERROR: Command \"" + cmd +
						"\" not recognized. Type '?' for help.");
				break;
			}
		}
	}

	private static void savePrefs() throws RemoteException {
		System.out.print(now()+"[Server] Saving preferences: ");
		p.put(sName, serverObject.getName());
		System.out.println("Saved!");
	}
	private static void loadPrefs() throws RemoteException {
		System.out.print(now()+"[Server] Loading preferences: ");
		serverObject.setName(p.get(sName, "Default Server"));
		System.out.println("Loaded!");
	}
	
	public static void printMsg(String msg) {
		System.out.println(now() + msg);
	}
	
	public static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("dd/HH:mm:ss z ");
		return x.format(now);
	}
	
	private static void setVariable(String arg) throws Exception, 
			RemoteException, NullPointerException {
		String var = null;
		try {
			int pos = arg.indexOf(" ");
			if (pos > 0) {
				var = arg.substring(pos);
				var = var.trim();
				arg = arg.substring(0, pos);
			}
			else var = null;
		} catch (Exception e) {
			System.out.println(now() + "[Server] Listing environmental variables:");
			System.out.println("'name': " + serverObject.getName());
			return;
		}
		
		switch (arg) {
		case "name":
			if (var == null) {
				System.out.println(now() + "[Server] 'name': " + 
						serverObject.getName());
				break;
			}
			serverObject.setName(var);
			System.out.println(now() + "[Server] 'name' set to: "
					+ serverObject.getName());
			break;
		default:
			System.out.println(now() + "Something went wrong in 'set'");
			break;
		}

	}
	
	private static void printLists(String arg) throws RemoteException {
		if (arg == null) { // no arguments stated
			System.out.println(now()+"[Server] No lists selected:");
			System.out.println("'users', 'gm', 'games', 'players'");
			return;
		}
		System.out.println(now()+"[Server/List] Printing list: '" + arg + "'");
		
		switch (arg) {
		case "gm":
		case "gamemaster":
		case "gamemasters":
			System.out.println(serverObject.printListGM());
			break;
		case "games":
		case "game":
			System.out.println(serverObject.printListGame());
			break;
		case "players":
		case "player":
			System.out.println(serverObject.printListPlayers());
			break;
		case "users":
		case "user":
		case "all":
			System.out.println("*** Gamemasters ***");
			System.out.println(serverObject.printListGM());
			System.out.println("*** Players ***");
			System.out.println(serverObject.printListPlayers());
			break;
		default:
			System.out.println("[List]: '" + arg + "' not recognized, try again");
			break;
		}
	}
	
	private static void printHelp() {
		String tab = "\t";
		System.out.println(now()+"[Server] Console: Help!");
		System.out.println(tab + "?" + tab + tab + tab + "This help screen");
		System.out.println(tab + "exit" + tab + tab + tab + "See 'shutdown'");
		System.out.println(tab + "list" + tab + tab + tab + "Lists " +
				"connections, etc.");
		System.out.println(tab + "shutdown" + tab + tab + "Shuts down " +
				"the server, requires a 'reason',");
		System.out.println(tab + tab + tab + tab + "that will be broadcast " +
				"to all logged in users");
	}
	
	private static void serverShutdown(String reason) {
		if (reason == null) { // no reason stated
			System.out.println(now()+"[Server] Shutdown called without reason, " +
					"spesify reason to shut down server.");
			return;
		}
		System.out.println(now()+"[Server] Shutdown called! Reason: " + reason);
		/* Transmit message to all connected users, games to autosave
		 * before disconnecting
		 */
		String servername = "jRMServer";
		try {
			Naming.unbind(servername);
		} catch (RemoteException e) {
			System.out.println(now()+"[Server] ERROR: Remote Exception, problems with connection");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println(now()+"[Server] ERROR: Malformed URL.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println(now()+"[Server] ERROR: RMI Service already unbound.");
			e.printStackTrace();
		}
		System.out.println(now()+"[Server] Shutting down!");
		System.exit(0);
	}
	
}
