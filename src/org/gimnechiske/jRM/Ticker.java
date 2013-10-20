package org.gimnechiske.jRM;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
/**
 * 
 * @author Aun Johnsen
 * 
 * Ticker invokes every second and on programmed intervals trigger
 * actions in game, gamemaster and players through local doTick
 * functions. The game in turn calls doTick in Monsters and NPC's
 * while the players call doTick in characters. The GM uses the 
 * tick to force update score tables and other.
 * 
 * The tick can also be invoked manually from the GamemasterApp's
 * game window, as well as the Gamemaster can start and stop automatic
 * ticking. The ticks are used to push round based actions (i.e. movement
 * longer than MBR, bleeding, healing, spells with duration, etc). It is
 * also used to determine the flow 
 */
public class Ticker implements Serializable {
	private static final long serialVersionUID = 1L;
	private Game masterObject;
	private int tick = 0;
	private boolean ticking;
	public int round = 10; // default 10 second rounds
	private int sec;
	private ArrayList<Player> p = new ArrayList<>();
	/**
	 * Constructor of the ticker object takes a game as argument, the
	 * game object will be called for each tick, and also Gamemaster and
	 * players are taken from that object.
	 * 
	 * @param owner - Game object that owns this ticker
	 */
	public Ticker(Game owner) {
		masterObject = owner;
		ticking = false;
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				doTick();
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * Sets the time interval between each tick in seconds
	 * 
	 * @param secs - the interval in seconds between each tick
	 */
	public synchronized void setRound(int secs) {
		round = secs;
	}
	/**
	 * 
	 * @return rounds - number of seconds between ticks
	 */
	public synchronized int getRound() {
		return round;
	}
	/**
	 * Start the ticking
	 */
	public synchronized void startTick() {
		ticking = true;
	}
	/**
	 * Stops the ticking
	 */
	public synchronized void stopTick() {
		ticking = false;
	}
	
	/**
	 * Master ticker that invokes all other doTick functions. This clock
	 * loops every second and filters the ticks based on variable options
	 * 
	 * If conditions is not met to tick this function exits without invoking
	 * a single tick, if conditions are met, all ticks are invoked
	 */
	public synchronized void doTick() {
		if (!ticking) return;
		sec++;
		if (sec <= round) return;
		sec = 0;
		tick++;
		if (tick > 9) {
			System.out.println(now() + "[Ticker] Tick!");
			tick = 0;
		}
		masterObject.doTick(); // tick game object first
		p = masterObject.getPlayerList();
		for (Player pl : p) pl.doTick(); // tick players in sequence
		masterObject.gameMaster.doTick(); // tick game master last
	}
	
	public static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("dd/HH:mm:ss z ");
		return x.format(now);
	}
	
}
