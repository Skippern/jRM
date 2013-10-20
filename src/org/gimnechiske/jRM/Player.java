package org.gimnechiske.jRM;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Aun Johnsen
 * 
 * Player object to handle communication between Player app and server
 */
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private String playerName;
	private Character charObj;
	private Game gameObj;
	public ArrayList<Message> messageQueue = new ArrayList<>();
	
	public Player() { }
	
	public synchronized void setName(String name) {
		playerName = name;
	}
	public synchronized String getName() {
		return playerName;
	}
	public synchronized void setCharacter(Character character) {
		charObj = character;
	}
	public synchronized Character getCharacter() {
		return charObj;
	}
	public synchronized void setGame(Game game) {
		gameObj = game;
	}
	public synchronized Game getGame() {
		return gameObj;
	}
	
	public synchronized void doTick() {
		System.out.println("[Player] Tick");
		charObj.doTick();
	}
	
	public String toString() {
		return playerName + " (" + charObj.getName() + ")";
	}

	public synchronized void addMessage(Message m) {
		messageQueue.add(m);
	}
	public synchronized ArrayList<Message> getMessages() {
		return messageQueue;
	}
	public synchronized int getQueueLength() {
		return messageQueue.size();
	}
	public synchronized ArrayList<Message> flushMessages() {
		ArrayList<Message> tmp = messageQueue;
		messageQueue.clear();
		return tmp;
	}
}
