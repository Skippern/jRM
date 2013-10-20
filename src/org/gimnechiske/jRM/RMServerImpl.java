package org.gimnechiske.jRM;

import java.rmi.*;
import java.rmi.server.*;
import java.text.*;
import java.util.*;

import org.gimnechiske.jRM.lib.RMSystem;
/**
 * 
 * @author Aun Johnsen
 *
 * Implementation of the RMServer
 */
public class RMServerImpl extends UnicastRemoteObject implements RMServer {
	private static final long serialVersionUID = 1L;
	
	private String serverName = "Default Server";

	private ArrayList<Gamemaster> GMList = new ArrayList<>();
	private ArrayList<Game> gameList = new ArrayList<>();
	private ArrayList<Player> playerList = new ArrayList<>();
	
	public RMServerImpl() throws RemoteException {
	}
	
	public synchronized String printListGM() {
		String ret = "";
		if (GMList.size() == 0) ret += "None";
		for (int i = 0; i < GMList.size(); i++) {
			ret = GMList.get(i).getName() + "\n";
		}
		return ret;
	}
	public synchronized String printListGame() {
		String ret = "";
		if (gameList.size() == 0) ret += "None";
		for (int i = 0; i < gameList.size(); i++) {
			ret = gameList.get(i).getName() + "\n";
		}
		return ret;
	}
	public synchronized String printListPlayers() {
		String ret = "";
		if (playerList.size() == 0) ret += "None";
		for (int i = 0; i < playerList.size(); i++) {
			ret = playerList.get(i).getName() + "\n";
		}
		return ret;
	}
	
	public synchronized void registerGM(Gamemaster gm) throws 
			RemoteException {
		try {
			GMList.add(gm);
			System.out.println(now()+"[Server/GM] " + gm.getName() + " logged in.");
			broadcast(RMSystem.MESSAGE_SYSTEM, "Server", gm.getName() + " entered chat.");
		} catch (Exception e) {
			System.out.println(now()+"[Server/GM] "+ e);
			e.printStackTrace();
		}
	}
	public synchronized void registerGame(Game game) throws RemoteException {
		try {
			gameList.add(game);
			System.out.println(now()+"[Server/Game] " + game.getName() + " created.");
			broadcast(RMSystem.MESSAGE_SYSTEM, "Server", game.getGamemaster().getName() + " registered a game: " + game.getName() + " (" + game.getWorld() + ")");
		} catch (Exception e) {
			System.out.println(now()+"[Server/Game] "+ e);
			e.printStackTrace();
		}
		if (game.isInvite()) System.out.println(now()+"[Server/Game] " + game.getName() +
				" accepts players (" + game.getPlayers() + "/" + 
				game.getMaxPlayers() + ")");
	}
	public synchronized void registerPlayer(Player player) throws 
			RemoteException {
		try {
			playerList.add(player);
			System.out.println(now()+"[Server/Player] " + player.getName() + " logged in.");
			broadcast(RMSystem.MESSAGE_SYSTEM, "Server", "Player " + player.getName() + " is looking for a game.");
		} catch (Exception e) {
			System.out.println(now()+"[Server/Player] "+ e);
			e.printStackTrace();
		}
	}
	public synchronized void signoutPlayer(String name) throws 
			RemoteException {
		boolean found = false;
		int playerIndex = 0;
		while (playerIndex < playerList.size() && !found) {
			Player thisOne = playerList.get(playerIndex);
			if ((thisOne.getName()).equals(name)) {
				found = true;
				playerList.remove(playerIndex);
				System.out.println(now()+"[Server/Player] " + name + " just left the game");
				broadcast(RMSystem.MESSAGE_SYSTEM, "Server", "Player " + name + " left the game");
			} playerIndex++;
		}
	}
	public synchronized void signoutGame(String name) throws 
			RemoteException {
		boolean found = false;
		int gameIndex = 0;
		while (gameIndex < gameList.size() && !found) {
			Game thisOne = gameList.get(gameIndex);
			if ((thisOne.getName()).equals(name)) {
				found = true;
				gameList.remove(gameIndex);
				System.out.println(now()+"[Server/Game] " + name + " terminated.");
				broadcast(RMSystem.MESSAGE_SYSTEM, "Server", "Game " + name + " terminated");
			} gameIndex++;
		}
	}
	public synchronized void signoutGM(String name) throws RemoteException {
		int gmIndex = 0;
		while (gmIndex < GMList.size() ) {
			Gamemaster thisOne = GMList.get(gmIndex);
			if ((thisOne.getName()).equals(name)) {
				broadcast(RMSystem.MESSAGE_SYSTEM, "Server", name + " left the chat.");
				GMList.remove(gmIndex);
				System.out.println(now()+"[Server/GM] " + name + " just left the game.");
			} gmIndex++;
		}
	}

	public synchronized void serverShutdown(String reason) throws 
			RemoteException {
		broadcast(RMSystem.MESSAGE_SHUTDOWN, "Server", "Server shutting down: " + reason);
		/* This function should call shutdown in the server */
	}

	public synchronized String getName() throws RemoteException {
		return serverName;
	}
	public synchronized static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("dd/HH:mm:ss z ");
		return x.format(now);
	}

	public synchronized String userNumbersFormated() throws RemoteException {
		String r = "(";
		r += GMList.size();
		r += "/";
		r += playerList.size();
		r += ")";
		return r;
	}

	public synchronized int countGM() throws RemoteException {
		return GMList.size();
	}

	public synchronized int countPlayers() throws RemoteException {
		return playerList.size();
	}

	public synchronized int countGames() throws RemoteException {
		return gameList.size();
	}
	public synchronized void setName(String name) throws RemoteException {
		serverName = name;
	}
	
	public synchronized void broadcast(int mType, String sender, String m) 
			throws RemoteException, NullPointerException {
		Message mess = new Message(mType, sender, m);
		for (int i = 0; i < GMList.size(); i++) {
			Gamemaster g = GMList.get(i);
			g.addMessage(mess);
		}
		for (int i = 0; i < playerList.size(); i++) {
			Player p = playerList.get(i);
			p.addMessage(mess);
		}
		for (int i = 0; i < gameList.size(); i++) {
			Game g = gameList.get(i);
			g.addMessage(mess);
		}
	}
	public synchronized Gamemaster getGamemaster(String name) {
		Gamemaster g = null;
		
		for (Gamemaster gm : GMList) {
			if (gm.getName().equals(name)) g = gm;
		}
		
		return g;
	}

	public synchronized Game getGame(String name) {
		Game g = null;
		/*
		for (Game game : gameList) {
			if (game.getName().equals(name)) g = game;
		}
		*/
		return g;
	}
}
