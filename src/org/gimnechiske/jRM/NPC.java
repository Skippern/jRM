package org.gimnechiske.jRM;

import org.gimnechiske.jRM.core.SkillCategory;

/**
 * 
 * @author Aun Johnsen
 * 
 * This is the object for Non-Player Characters, a quick and easy way for
 * a GM to create other persons with which the characters/players can
 * interact.
 * 
 * GM should be able to chat through NPC's, as well as give them instructions
 * like using skills on the players (pick pockets), and take part in combat,
 * spell casting, etc. These can be friends and foes
 * 
 * The GM should have access to an interface to quickly create NPC's as
 * needed as well as store pre-made NPC's
 * 
 * There should be a way to script NPC's to make NPC's act as some sort of AI
 * 
 * The NPC interface is almost a clone of the Character interface (only
 * player specific functions is the difference)
 */
public interface NPC extends Living {
	public SkillCategory[] getSkillCategories();
	public Skill[] getSkills();
	public int getSkillBonus(Skill s);
	public Talent[] getTalents();
	public Flaw[] getFlaws();
	public TrainingPackage[] getTrainingPackages();
	public Profession getProfession();
}
