package org.gimnechiske.jRM;

import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.table.*;

public interface Skill extends Ability {
	public SkillCategory getCategory();
	public String getName();
	public String getSpecialization();
	public String getDescription();
	public double getExhaustion();
	public double[] getProgression();
	public Maneuver getResult(int dice);
	public double getDistanceMultiplier();
	public int getRanks();
	public int[] getDevCost(Profession prof);
	public int getRankBonus();
	public int getCategoryBonus();
	public int getItemBonus();
	public int getSpecialBonus();
	public int getTemporaryBonus();
	public int getTotalBonus();
	public int getManeuverType();
	public boolean isCombatSkill();
	public boolean isSpezialized();
	public void addRanks(int ranks);
	public void setItemBonus(int bonus);
	public void setSpecialBonus(int bonus);
	public void setTemporaryBonus(int bonus);
	public void setSpezialization(String spec);
}
