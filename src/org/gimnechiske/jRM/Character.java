package org.gimnechiske.jRM;

import java.util.ArrayList;

import org.gimnechiske.jRM.core.SkillCategory;

/**
 * 
 * @author Aun Johnsen
 * 
 * Represents the character of the player. This is the object creating
 * the character sheet, and can be interrogated by the GM and other players
 * for information.
 * 
 * The character object can be saved on the player's computer to be used
 * in a later game. The application should be made so that a stored character
 * can only be loaded after joining a game, same with creating a new
 * character.
 * 
 * The GM should also be able to check the character sheet of a character
 * before accepting him into a game, and at any time during a game.
 * 
 * Question is if a character can be stored with the GM and handed to
 * players?
 * 
 * Characters should be able to stack commands (continuous list of commands
 * during combat, etc), and simple scripting (pre-made sequences and some
 * conditional scripts such as "running out of bullets; draw dagger")
 * 
 * Character scripts must be started manually, no automatic playing should
 * be allowed
 */
public interface Character extends Living {
	public Player getPlayer();
	
	public ArrayList<SkillCategory> getSkillCategories();
	public ArrayList<Skill> getSkills();
	public Profession getProfession();
	public int getSkillBonus(Skill s);
	public ArrayList<Talent> getTalents();
	public ArrayList<Flaw> getFlaws();
	public TrainingPackage[] getTrainingPackages();
	public Race getRaceObject();
	public boolean hasDing();
	public int getPPExhaustion();
	public int getMPExhaustion();
	public int getHitExhaustion();
	public int getExhaustionPenalty();
}
