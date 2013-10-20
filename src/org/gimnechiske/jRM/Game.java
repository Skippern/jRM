package org.gimnechiske.jRM;

import java.io.*;
import java.util.*;

import javax.swing.*;

import org.gimnechiske.jRM.gui.map.Map;

/**
 * 
 * @author Aun Johnsen
 * 
 * The Game object to keep track of which players are connected, it is
 * needed to take care of the chat, and gaming events
 */
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	private String gameName;
	private String worldName;
	private String magicLevel;
	private String heroLevel;
	private String techLevel;
	private String gameSetting;
	private boolean invite = false;
	private int minPlayers = 1;
	private int maxPlayers = 2;
	public ArrayList<Player> playerList = new ArrayList<>();
	public ArrayList<NPC> npcList = new ArrayList<>();
	public ArrayList<Monster> monsterList = new ArrayList<>();
	public ArrayList<Ability> abilityList = new ArrayList<>();
	public ArrayList<Message> messageQueue = new ArrayList<>();
	public Gamemaster gameMaster;
	private boolean started = false;
	private Ticker clock;
	private Map worldMap;
	
	public Game(Gamemaster gm, String sessionName) {
		gameMaster = gm;
		gameName = sessionName;
		clock = new Ticker(this);
	}
	
	public synchronized Ticker getTicker() {
		return clock;
	}
	public synchronized void setWorld(String name) {
		worldName = name;
	}
	public synchronized String getWorld() {
		return worldName;
	}
	public synchronized void setMagic(String level) {
		magicLevel = level;
	}
	public synchronized String getMagic() {
		return magicLevel;
	}
	public synchronized void setHero(String level) {
		heroLevel = level;
	}
	public synchronized String getHero() {
		return heroLevel;
	}
	public synchronized void setTechnology(String level) {
		techLevel = level;
	}
	public synchronized String getTechnology() {
		return techLevel;
	}
	public synchronized void setSetting(String setting) {
		gameSetting = setting;
	}
	public synchronized String getSetting() {
		return gameSetting;
	}
	
	public synchronized void setName(String name) {
		gameName = name;
	}
	public synchronized String getName() {
		return gameName;
	}
	/**
	 * Opens game for invites (players can join) (automatically
	 * stops a started game)
	 */
	public synchronized void openInvite() {
		started = false;
		invite = true;
	}
	/** 
	 * Closes game for invites (players can no longer join)
	 */
	public synchronized void closeInvite() {
		invite = false;
	}
	/**
	 * 
	 * @return true if players can join game, else false
	 */
	public synchronized boolean isInvite() {
		return invite;
	}
	/**
	 * Sets the minimum players required to start the game
	 * @param players
	 */
	public synchronized void setMinPlayers(int players) {
		minPlayers = players;
	}
	/**
	 * Sets the maximum players allowed in the game
	 * @param players
	 */
	public synchronized void setMaxPlayers(int players) {
		maxPlayers = players;
	}
	/**
	 * 
	 * @return int Maximum number of players in the game
	 */
	public synchronized int getMaxPlayers() {
		return maxPlayers;
	}
	/**
	 * 
	 * @return int the number of players currently in the game
	 */
	public synchronized int getPlayers() {
		return playerList.size();
	}
	/**
	 * 
	 * @return true if requirements to start the game are met, else false
	 */
	public synchronized boolean canStartGame() {
		return minPlayers <= playerList.size();
	}
	/**
	 * 
	 * @return the number of vacant places for players in the game
	 */
	public synchronized int getVacansies() {
		return maxPlayers - playerList.size();
	}
	/**
	 * 
	 * @return Gamemaster object
	 */
	public synchronized Gamemaster getGamemaster() {
		return gameMaster;
	}
	/**
	 * Called by the ticker, calls doTick() in each tickable object
	 * in the game
	 */
	public synchronized void doTick() {
		/* Ticker code */
		for (NPC n : npcList) n.doTick();
		for (Monster m : monsterList) m.doTick();
		for (Player p : playerList) p.doTick();
	}
	/**
	 * Starts the game, a started game can tick (automatically close 
	 * invite to an open)
	 */
	public synchronized void startGame() {
		invite = false;
		started = true;
	}
	/**
	 * 
	 * @return true if game have started
	 */
	public synchronized boolean isStarted() {
		return started;
	}
	/**
	 * Stops the game, players can only join a stopped game - does not
	 * open invites
	 */
	public synchronized void stopGame() {
		started = false;
	}
	/**
	 * 
	 * @param p Player to join the game
	 */
	public synchronized void addPlayer(Player p) {
		playerList.add(p);
	}
	/**
	 * 
	 * @param p Player to remove from the game
	 */
	public synchronized void removePlayer(Player p) {
		playerList.remove(p);
	}
	/**
	 * 
	 * @return Player list object
	 */
	public synchronized ArrayList<Player> getPlayerList() {
		return playerList;
	}
	/**
	 * 
	 * @return lists all players in the game
	 */
	public synchronized String printPlayerList() {
		return playerList.toString();
	}
	/**
	 * 
	 * @param m World map, to illustrate the world and as a base map
	 */
	public synchronized void setWorldMap(Map m) {
		worldMap = m;
	}
	/**
	 * 
	 * @return Map object for the world map
	 */
	public synchronized Map getWorldMap() {
		return worldMap;
	}
	public synchronized Icon getMapIcon() {
		if (worldMap == null) {
			// return default icon
			return null;
		}
		return worldMap.getMapIcon();
	}
	
	public synchronized void addNPC(NPC n) {
		npcList.add(n);
	}
	public synchronized void addMonster(Monster m) {
		monsterList.add(m);
	}
	public synchronized void removeNPC(NPC n) {
		npcList.remove(n);
	}
	public synchronized void removeMonster(Monster m) {
		monsterList.add(m);
	}
	public synchronized ArrayList<NPC> getNPCs() {
		return npcList;
	}
	public synchronized ArrayList<Monster> getMonsters() {
		return monsterList;
	}

	public int getTechnologyLevel() {
		int i = 0;
		switch (magicLevel) {
		case "High Magic":
			i -= 1;
			break;
		case "Medium Magic":
			break;
		case "Low Magic":
			i += 1;
			break;
		case "No Magic":
			i += 2;
			break;
		default:
			break;
		}
		switch (heroLevel) {
		case "Common":
		case "Heroic":
		case "Legendary":
		case "Fantastic":
		case "Superheroic":
			break;
		case "Devine Intervention":
			i -= 1;
			break;
		default:
			break;
		}
		switch (techLevel) {
		case "Stone Age":
			i -= 5;
			break;
		case "Copper Age":
			i -= 4;
			break;
		case "Bronze Age":
			i -= 3;
			break;
		case "Iron Age":
			i -= 2;
			break;
		case "Age of Empire":
			i -= 1;
			break;
		case "Middle Ages":
			break;
		case "Renaissance":
			i += 1;
			break;
		case "Age of Reason":
			i += 2;
			break;
		case "Industrial Revolution":
			i += 3;
			break;
		case "Age of Steam":
			i += 4;
			break;
		case "Electric Age":
			i += 5;
			break;
		case "Atomic Age":
			i += 6;
			break;
		case "Information Age":
			i += 7;
			break;
		case "Space Age":
			i += 8;
			break;
		default:
			break;
		}
		switch (gameSetting) {
		case "Fantasy":
		case "High Fantasy":
		case "Science Fiction":
		case "Steam Punk":
		case "Pulp":
		case "Post Apocalyptic":
		case "Cartoon":
		case "Horror":
		case "Crime":
		case "Hack'n'Slash":
		default:
			break;
		}
		return i;
	}
	public int getSiegeLevel() {
		int i = 0;
		switch (magicLevel) {
		case "High Magic":
		case "Medium Magic":
		case "Low Magic":
		case "No Magic":
		default:
			break;
		}
		switch (heroLevel) {
		case "Common":
		case "Heroic":
		case "Legendary":
		case "Fantastic":
		case "Superheroic":
		case "Devine Intervention":
		default:
			break;
		}
		switch (techLevel) {
		case "Stone Age":
		case "Copper Age":
		case "Bronze Age":
		case "Iron Age":
		case "Age of Empire":
		case "Middle Ages":
		case "Renaissance":
		case "Age of Reason":
		case "Industrial Revolution":
		case "Age of Steam":
		case "Electric Age":
		case "Atomic Age":
		case "Information Age":
		case "Space Age":
		default:
			break;
		}
		switch (gameSetting) {
		case "Fantasy":
		case "High Fantasy":
		case "Science Fiction":
		case "Steam Punk":
		case "Pulp":
		case "Post Apocalyptic":
		case "Cartoon":
		case "Horror":
		case "Crime":
		case "Hack'n'Slash":
		default:
			break;
		}
		return i;
	}
	public int getTrapBuildingLevel() {
		int i = 0;
		switch (magicLevel) {
		case "High Magic":
		case "Medium Magic":
		case "Low Magic":
		case "No Magic":
		default:
			break;
		}
		switch (heroLevel) {
		case "Common":
		case "Heroic":
		case "Legendary":
		case "Fantastic":
		case "Superheroic":
		case "Devine Intervention":
		default:
			break;
		}
		switch (techLevel) {
		case "Stone Age":
		case "Copper Age":
		case "Bronze Age":
		case "Iron Age":
		case "Age of Empire":
		case "Middle Ages":
		case "Renaissance":
		case "Age of Reason":
		case "Industrial Revolution":
		case "Age of Steam":
		case "Electric Age":
		case "Atomic Age":
		case "Information Age":
		case "Space Age":
		default:
			break;
		}
		switch (gameSetting) {
		case "Fantasy":
		case "High Fantasy":
		case "Science Fiction":
		case "Steam Punk":
		case "Pulp":
		case "Post Apocalyptic":
		case "Cartoon":
		case "Horror":
		case "Crime":
		case "Hack'n'Slash":
		default:
			break;
		}
		return i;
	}
	public int getArchitectLevel() {
		int i = 0;
		switch (magicLevel) {
		case "High Magic":
		case "Medium Magic":
		case "Low Magic":
		case "No Magic":
		default:
			break;
		}
		switch (heroLevel) {
		case "Common":
		case "Heroic":
		case "Legendary":
		case "Fantastic":
		case "Superheroic":
		case "Devine Intervention":
		default:
			break;
		}
		switch (techLevel) {
		case "Stone Age":
		case "Copper Age":
		case "Bronze Age":
		case "Iron Age":
		case "Age of Empire":
		case "Middle Ages":
		case "Renaissance":
		case "Age of Reason":
		case "Industrial Revolution":
		case "Age of Steam":
		case "Electric Age":
		case "Atomic Age":
		case "Information Age":
		case "Space Age":
		default:
			break;
		}
		switch (gameSetting) {
		case "Fantasy":
		case "High Fantasy":
		case "Science Fiction":
		case "Steam Punk":
		case "Pulp":
		case "Post Apocalyptic":
		case "Cartoon":
		case "Horror":
		case "Crime":
		case "Hack'n'Slash":
		default:
			break;
		}
		return i;
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
