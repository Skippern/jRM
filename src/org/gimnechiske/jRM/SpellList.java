package org.gimnechiske.jRM;
import java.util.ArrayList;

import org.gimnechiske.jRM.core.SkillCategory;

public interface SpellList {
	public int getRealm();
	public SkillCategory getCategory();
	public int getSpellCategory();
	public Race getRace();
	public Profession getBase();
	public String getName();
	public String getDescription();
	public String getNote();
	public ArrayList<Spell> getSpells();
}
