package org.gimnechiske.jRM.skills;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.lib.Maneuvers;
import org.gimnechiske.jRM.table.*;

public class SoftLeatherArmor implements Skill {
	private SkillCategory myCat;
	private int myRanks;
	private int itemBonus;
	private int temporaryBonus;
	private int specialBonus;
	
	public SoftLeatherArmor(SkillCategory sc) {
		myCat = sc;
	}
	public SkillCategory getCategory() {
		return myCat;
	}
	public String getName() {
		return "Soft Leather Armor";
	}
	public String getDescription() {
		return "The heavy outer garments normally worn as weather " + 
				"protection by certain civilians and as combat " +
				"protection by some militia and irregulars.";
	}
	public double getExhaustion() {
		return 1.0;
	}
	public double getDistanceMultiplier() {
		return 1;
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
