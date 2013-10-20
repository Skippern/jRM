package org.gimnechiske.jRM.core;

import java.util.ArrayList;

import org.gimnechiske.jRM.Ability;
import org.gimnechiske.jRM.Character;
import org.gimnechiske.jRM.Profession;
import org.gimnechiske.jRM.Skill;
import org.gimnechiske.jRM.table.*;

public interface SkillCategory extends Ability {
	public double[] getProgression();
	public double[] getSkillProgression();
	public double getRanks();
	public String getDescription();
	public String getName();
	public Maneuver getResult(int dice);
	public int[] getDevCost(Profession prof);
	public int getRankBonus();
	public int getStatBonus(Character c);
	public int getProfBonus(Profession prof);
	public int getSpecialBonus();
	public int getTemporaryBonus();
	public int getTotalBonus();
	public String getGroup();
	public ArrayList<Skill> getSkills();
	public boolean isCombatSkill(); // for TP calculations
	public int[] getStats();
}
