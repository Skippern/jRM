package org.gimnechiske.jRM;
/**
 * 
 * @author Aun Johnsen
 *
 */
import java.rmi.*;

public interface RMServer extends Remote {
	void registerGM(Gamemaster gm) throws RemoteException;
	void registerGame(Game game) throws RemoteException;
	void registerPlayer(Player player) throws RemoteException;
	void signoutPlayer(String name) throws RemoteException;
	void signoutGame(String name) throws RemoteException;
	void signoutGM(String name) throws RemoteException;
	void serverShutdown(String reason) throws RemoteException;
	String getName() throws RemoteException;
	String printListGM() throws RemoteException;
	String printListGame() throws RemoteException;
	String printListPlayers() throws RemoteException;
	String userNumbersFormated() throws RemoteException;
	int countGM() throws RemoteException;
	int countPlayers() throws RemoteException;
	int countGames() throws RemoteException;
	void setName(String name) throws RemoteException;
//	public Gamemaster getGamemaster(String name);
//	public Game getGame(String name);
	
	public void broadcast(int mType, String gm, String m) throws RemoteException;
}
