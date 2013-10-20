package org.gimnechiske.jRM;

import java.io.*;
/**
 * 
 * @author Aun Johnsen
 * 
 * Base of all living objects - this interface holds all functions related
 * to hits, PP, exhaustion, damage, movement, etc.
 * 
 * This interface is not to be used directly, but should in turn be
 * implemented in Monsters (beasts, animals, etc), NPCs (non-player 
 * characters) and (player) characters.
 * 
 * This holds all functions in common for living creatures.
 */
public interface Living extends Serializable {
	public String getRace();
	public String getName();
	public String getDescription();
	public int[] getStats(); // temp stats
	public int[] getPotStats(); // pot stats
	public int[] getStatRaceBonus(); // race bonus
	public int[] getStatSpecialBonus(); // special bonus
	public int[] getStatBonuses(); // total stat bonus
	/* Hit points and physical damage */
	public int getMaxHits(); 
	public int getCurrentHits();
	public double getHitPercent();
	public void dealConcussionHits(int damage, int damageType);
	public void healConcussionHits(int heal);
	public void dealBleeding(int bleed, int damageType);
	public void healBleeding(int bleed);
	public int getBleed();
	public void addStun(int rounds, int damageType);
	public void removeStun(int rounds);
	public int getStun();
	public boolean isConcious();
	public boolean isDead();
	/* Exhaustion and endurance */
	public int getMaxExh();
	public int getCurrentExh();
	public double getExhPercent();
	/* Power Points and Magic */
	public int getMaxPP();
	public int getCurrentPP();
	public double getPPPercent();
	/* Corruption of body and mind */
	public int getCorruption();
	public void addCorruption(int corruption);
	/* Grace and divine favors */
	public int getGrace();
	public void addGrace(int grace); // #5809 Channeling Companion
	/* Mind Points and Psychic abilities */
	public int getMaxMP();
	public int getCurrentMP();
	public double getMPPercent();
	/* Experience and levels */
	public int getExperience();
	public int getLevel();
	public void addExperience(int experience);
	/* Movement, speed and defense */
	public int getBaseMove();
	public int getMaxPace();
	public int getManeuverBonus();
	public int getManeuverSpeed();
	public int getAttackQuickness();
	/* Size and critical */
	public int getCreatureSize();
	public int getCreatureCritical();
	/* Armor and defense */
	public int getArmorType();
	public int getDefensiveBonus();
	/* Round update */	
	public void doTick();
	/* AI, scripting, etc */
	public void setAI();
	public void getAI();

}
