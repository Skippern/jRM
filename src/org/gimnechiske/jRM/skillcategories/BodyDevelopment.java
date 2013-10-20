package org.gimnechiske.jRM.skillcategories;

import java.util.ArrayList;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.Character;
import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.lib.*;
import org.gimnechiske.jRM.skills.*;
import org.gimnechiske.jRM.table.*;

public class BodyDevelopment implements SkillCategory {
	private ArrayList<Skill> skillList = new ArrayList<>();
	private int temporaryBonus;
	private int storedProfBonus;
	private int storedStatBonus;
	private Race myRace;
	
	public BodyDevelopment() {
		Skill s = new BodyDevelopmentSkill(this);
		skillList.add(s);
	}

	public double[] getProgression() {
		return Progression.NONE;
	}
	public double[] getSkillProgression() {
		if (myRace != null) return myRace.getBodyDev();
		return Progression.NONE;
	}

	public double getRanks() {
		return 0;
	}
	public String getDescription() {
		return null;
	}
	public String getName() {
		return "Body Development";
	}
	public int[] getDevCost(Profession prof) {
		return prof.getDevCost(this);
	}
	public int getRankBonus() {
		return 0;
	}
	public int getSpecialBonus() {
		return 10;
	}
	public int getTemporaryBonus() {
		return temporaryBonus;
	}
	public int getTotalBonus() {
		int i = getRankBonus();
		i += getSpecialBonus();
		i += storedStatBonus;
		i += storedProfBonus;
		i += getTemporaryBonus();
		return i;
	}
	public String getGroup() {
		return "Body";
	}
	public int getStatBonus(Character c) {
		int[] s = getStats();
		int[] r = c.getStatBonuses();
		myRace = c.getRaceObject();
		int i = 0;
		for (int j = 0; j < s.length; j++) i += r[s[j]];
		storedStatBonus = i;
		return i;
	}
	public int getProfBonus(Profession prof) {
		storedProfBonus = prof.getProfessionBonus(this);
		return storedProfBonus;
	}
	public Maneuver getResult(int dice) {
		return null;
	}
	public ArrayList<Skill> getSkills() {
		return skillList;
	}
	public boolean isCombatSkill() {
		return false;
	}
	public int[] getStats() {
		int[] tmp = { LibStats.CO, LibStats.SD, LibStats.CO };
		return tmp;
	}
}
