package org.gimnechiske.jRM;

import java.util.ArrayList;

public interface TrainingPackage {
	public String getName();
	public String getDescription();
	public String getExtraMoney();
	public int getTimeToAquire();
	public String[] getRewards();
	public ArrayList<Ability> getSkills();
	public boolean isLifestyle();
	public int[] getStatGains();
	public int getDevCost(Profession p);
}
