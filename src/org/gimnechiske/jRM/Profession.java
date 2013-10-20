package org.gimnechiske.jRM;

import org.gimnechiske.jRM.core.SkillCategory;

public interface Profession {
	public int[] getPrimeStats();
	public String getName();
	public String getDescription();
	public int getRealm(); // Primary realm (actual realm except for hybrid spell users
	public int getRealm2(); // Secondary realm (not visible except for hybrid and semi spell users
	public int[] getDevCost(SkillCategory sc);
	public int getProfessionBonus(SkillCategory sc);
	public Skill[] getEverymanSkills();
	public Skill[] getOccupationalSkills();
	public Skill[] getRestrictedSkills();
	public boolean isEverymanSkill(Skill s);
	public boolean isOccupationalSkill(Skill s);
	public boolean isRestrictedSkill(Skill s);
}
