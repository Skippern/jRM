package org.gimnechiske.jRM;

import org.gimnechiske.jRM.table.Maneuver;

public interface Spell {
	public String getName();
	public String getDescription();
	public String getAOE();
	public String getDuration();
	public String getRange();
	public String getSpellType();
	public String getSubType();
	public boolean isInstantanous();
	public boolean isNoPPSpell();
	public boolean isPartOfSet();
	public boolean isPermanent();
	public boolean isConcentration();
	public Maneuver getResult(int dice);
}
