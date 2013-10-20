package org.gimnechiske.jRM;

import java.util.*;

public interface Culture {
	public String getName();
	public String getDescription();

	public ArrayList<Ability> getAdolescence();
	
	public int getArchitectLevel();
	public int getSiegeLevel();
	public int getTrapBuildingLevel();
	public int getTechnologyLevel();
	public double getLaborEffectiveness();
}
