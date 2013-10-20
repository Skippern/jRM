package org.gimnechiske.jRM;

import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.table.Maneuver;

public interface Psychic {
	public String getName();
	public String getDescription();
	public SkillCategory getCategory();
	public int getType();
	public double getMagnitude();
	public double getMaintenance();
	public String getAOE();
	public String getDuration();
	public String getRange();
	public Maneuver getResult(int dice);

}
