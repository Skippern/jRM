package org.gimnechiske.jRM.skills;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.lib.Maneuvers;
import org.gimnechiske.jRM.table.*;

public class Observation implements Skill {
	private SkillCategory myCat;
	private int myRanks;
	private int itemBonus;
	private int temporaryBonus;
	private int specialBonus;
	
	public Observation(SkillCategory sc) {
		myCat = sc;
	}
	public SkillCategory getCategory() {
		return myCat;
	}
	public String getName() {
		return "Observation";
	}
	public String getDescription() {
		return "This skill provides a bonus for noticing details about " +
				"the environment for assimilation and analysis. This is " +
				"normally only usable in an active fashionm and requires " +
				"concentration. Note that this skill is different from " +
				"Alertness, which represents a general and unconscious " +
				"level of receptivity and awareness of events and details " +
				"within one's immediate environment. This skill reflects " +
				"the active observation, noting and appraisal of such " +
				"details. For example, if a character were about to make " +
				"camp in an unsafe location, the GM might make an Alertness " +
				"static maneuver for that character to determine whether " +
				"or not he notices the danger. If the character indicated " +
				"that he wished to examine the location for suitability, " +
				"the character would instead make an Observation static " +
				"maneuver.";
	}
	public double getExhaustion() {
		return 0;
	}
	public double getDistanceMultiplier() {
		return 0.3;
	}
	public double[] getProgression() {
		return myCat.getSkillProgression();
	}
	public Maneuver getResult(int dice) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getRanks() {
		return myRanks;
	}
	public int[] getDevCost(Profession prof) {
		return myCat.getDevCost(prof);
	}
	public int getRankBonus() {
		double[] p = getProgression();
		double i = 0.0;
		int r = myRanks;
		if (r < 1) return (int) p[0];
		if (r < 11) i += r * p[1];
		else {
			r -= 10;
			i += 10 * p[1];
		}
		if (r < 11) i += r * p[2];
		else {
			r -= 10;
			i += 10 * p[2];
		}
		if (r < 11) i += r * p[3];
		else {
			r -= 10;
			i += 10 * p[3];
		}
		if (r > 0) i += r * p[4];
		return (int) i;
	}
	public int getCategoryBonus() {
		return myCat.getTotalBonus();
	}
	public int getItemBonus() {
		return itemBonus;
	}
	public int getSpecialBonus() {
		return specialBonus;
	}
	public int getTemporaryBonus() {
		return temporaryBonus;
	}
	public int getTotalBonus() {
		int i = getRankBonus();
		i += getCategoryBonus();
		i += getItemBonus();
		i += getSpecialBonus();
		i += getTemporaryBonus();
		return i;
	}
	public int getManeuverType() {
		return Maneuvers.MM;
	}
	public boolean isCombatSkill() {
		return myCat.isCombatSkill();
	}
	public void addRanks(int ranks) {
		myRanks += ranks;
	}
	public void setItemBonus(int bonus) {
		itemBonus = bonus;
	}
	public void setSpecialBonus(int bonus) {
		specialBonus = bonus;
	}
	public void setTemporaryBonus(int bonus) {
		temporaryBonus = bonus;
	}
	public String getSpecialization() {
		return null;
	}
	public boolean isSpezialized() {
		return false;
	}
	public void setSpezialization(String spec) {
	}
}
