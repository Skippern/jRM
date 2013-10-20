package org.gimnechiske.jRM;

import java.util.ArrayList;

import org.gimnechiske.jRM.core.*;
import org.gimnechiske.jRM.lib.LibStats;
import org.gimnechiske.jRM.skillcategories.*;
import org.gimnechiske.jRM.skills.*;

public class CharacterSheet implements Character {
	private static final long serialVersionUID = 1L;
	private Race race;
	private String name;
	private String description;
	private int[] tempStats = {};
	private int[] potStats = {};
	private int[] specialStats = {};
	private Player player;
	private Profession profession;
	private ArrayList<SkillCategory> skillCats = new ArrayList<>();
	private ArrayList<Skill> skills = new ArrayList<>();
	private ArrayList<Talent> talent = new ArrayList<>();
	private ArrayList<Flaw> flaw = new ArrayList<>();
	private TrainingPackage[] trainingPackage = {};
	private int stun;
	private boolean concious = true;
	private boolean dead = false;
	private int bleed;
	private int corruption;
	private int grace;
	private int experience;
	private int damage;
	private int level;
	private int usedPP;
	private int usedMP;
	private int usedExh;
	private double spellCoolDown;
	private double psychicCoolDown;

	public String getRace() {
		return race.getName();
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int[] getStats() {
		return tempStats;
	}
	public int[] getPotStats() {
		return potStats;
	}
	public int[] getStatRaceBonus() {
		return race.getRaceStats();
	}
	public int[] getStatSpecialBonus() {
		return specialStats;
	}
	public int[] getStatBonuses() {
		int[] tmp = { };
		int[] rtmp = getStatRaceBonus();
		int[] stmp = getStatSpecialBonus();
		for (int i = 0; i < rtmp.length; i++) {
			tmp[i] = rtmp[i] + stmp[i];
		}
		for (int i = 0; i < tmp.length; i++) {
			int j = tempStats[i];
			if (j > 100) tmp[i] += (int) (j - 95) * 2;
			else if (j > 89) tmp[i] += (int) (j - 81) / 2;
			else if (j > 69) tmp[i] += (int) (j - 67) / 5;
			else if (j < 11) tmp[i] += (int) (j - 21) / 2;
			else if (j < 31) tmp[i] += (int) (j - 33) / 5;
		}
		return tmp;
	}

	public int getMaxHits() {
		Skill b = new BodyDevelopmentSkill(new BodyDevelopment());
		int i = getSkillBonus(b);
		return i;
	}

	public int getCurrentHits() {
		return getMaxHits() - damage;
	}

	public double getHitPercent() {
		double maxHit = getMaxHits();
		double curHit = getCurrentHits();
		double p = (1 / (curHit / maxHit)) * 100.0;
		return p;
	}

	@Override
	public void dealConcussionHits(int damage, int damageType) {
		// TODO Auto-generated method stub
		
	}

	public void healConcussionHits(int heal) {
		damage -= heal;
		if (damage < 0) damage = 0;
	}

	@Override
	public void dealBleeding(int bleed, int damageType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void healBleeding(int bleed) {
		this.bleed -= bleed;
	}

	public int getBleed() {
		return bleed;
	}

	@Override
	public void addStun(int rounds, int damageType) {
		// TODO Auto-generated method stub
		
	}

	public void removeStun(int rounds) {
		stun -= rounds;
	}

	public int getStun() {
		return stun;
	}

	public boolean isConcious() {
		return concious;
	}

	public boolean isDead() {
		return dead;
	}

	@Override
	public int getMaxExh() {
		// TODO Auto-generated method stub
		// 40 + (3 x Co) + any special bonuses
		return 40 + (getStatBonuses()[LibStats.CO] * 3);
	}

	public int getCurrentExh() {
		return getMaxExh() - usedExh;
	}

	public double getExhPercent() {
		double maxExh = getMaxExh();
		double curExh = getCurrentExh();
		double p =(1 / (curExh / maxExh)) * 100.0;
		return p;
	}

	@Override
	public int getMaxPP() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCurrentPP() {
		return getMaxPP() - usedPP;
	}

	@Override
	public double getPPPercent() {
		double maxPP = getMaxPP();
		double curPP = getCurrentPP();
		double p = (1 / (curPP / maxPP)) * 100.0;
		return p;
	}

	public int getCorruption() {
		return corruption;
	}

	public void addCorruption(int corruption) {
		this.corruption += corruption;
	}

	public int getGrace() {
		return grace;
	}

	public void addGrace(int grace) {
		this.grace += grace;
	}

	@Override
	public int getMaxMP() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCurrentMP() {
		return getMaxMP() - usedMP;
	}

	public double getMPPercent() {
		double maxMP = getMaxMP();
		double curMP = getCurrentMP();
		double p = (1 / (curMP / maxMP)) * 100.0;
		return p;
	}

	public int getExperience() {
		return experience;
	}

	public int getLevel() {
		return level;
	}

	public void addExperience(int experience) {
		this.experience += experience;
	}

	@Override
	public int getBaseMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxPace() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getManeuverBonus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getManeuverSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAttackQuickness() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCreatureSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCreatureCritical() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArmorType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDefensiveBonus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void doTick() {
		removeStun(1);
		damage += bleed;
		if (spellCoolDown < 1.0) spellCoolDown = 0.0;
		else spellCoolDown -= 1.0;
		if (psychicCoolDown < 1.0) psychicCoolDown = 0.0;
		else psychicCoolDown -= 1.0;
	}

	@Override
	public void setAI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAI() {
		// TODO Auto-generated method stub
		
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<SkillCategory> getSkillCategories() {
		return skillCats;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public Profession getProfession() {
		return profession;
	}

	public int getSkillBonus(Skill s) {
		int i = skills.indexOf(s);
		Skill sk = skills.get(i);
		return sk.getTotalBonus();
	}

	public ArrayList<Talent> getTalents() {
		return talent;
	}

	public ArrayList<Flaw> getFlaws() {
		return flaw;
	}

	public TrainingPackage[] getTrainingPackages() {
		return trainingPackage;
	}

	public Race getRaceObject() {
		return race;
	}

	public boolean hasDing() {
		if (level == 0 && experience > 0) return true;
		if (experience < 50000 && (experience / 10000 ) > level) return true;
		if (experience < 150000 && ((experience - 50000) / 20000) > (level - 5)) return true;
		if (experience < 300000 && ((experience - 150000) / 30000) > (level - 10)) return true;
		if (experience < 500000 && ((experience - 300000) / 40000) > (level - 15)) return true;
		if (((experience - 500000) / 50000) > (level - 20)) return true; 
		return false;
	}
	public int getPPExhaustion() {
		if (getPPPercent() > 75.0) return -30;
		if (getPPPercent() > 50.0) return -20;
		if (getPPPercent() > 25.0) return -10;
		return 0;
	}
	public int getHitExhaustion() {
		if (getHitPercent() > 75.0) return -30;
		if (getHitPercent() > 50.0) return -20;
		if (getHitPercent() > 25.0) return -10;
		return 0;
	}
	public int getExhaustionPenalty() {
		if (getExhPercent() > 100.0) return -100;
		if (getExhPercent() > 90.0) return -60;
		if (getExhPercent() > 75.0) return -30;
		if (getExhPercent() > 50.0) return -15;
		if (getExhPercent() > 25.0) return -5;
		return 0;
	}
	public int getMPExhaustion() {
		if (getMPPercent() > 75.0) return -30;
		if (getMPPercent() > 50.0) return -20;
		if (getMPPercent() > 25.0) return -10;
		return 0;
	}
	public int getUnrestrictedPsychicCats() {
		int sd = tempStats[LibStats.SD];
		if (sd > 100) return 5;
		if (sd > 99) return 4;
		if (sd > 97) return 3;
		if (sd > 69) return 2;
		if (sd > 30) return 1;
		return 0;
	}
	public int getSpellCooldownTime() {
		return (int) spellCoolDown;
	}
	public int getPsychicCooldownTime() {
		return (int) psychicCoolDown;
	}
	public void addSpellCooldown(double time) {
		spellCoolDown += time;
	}
	public void addPsychicCooldown(double time) {
		psychicCoolDown += time;
	}
}
