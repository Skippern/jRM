package org.gimnechiske.jRM.core;

public interface Stat {
	public String getName();
	public String getShortName();
	public String getDescription();
	public int getTemp();
	public int getPot();
	public void setTemp(int newTemp);
	public void setPot(int newPot);
	public int getBasicBonus();
	public int getRacialBonus();
//	public int getRacialBonus(Race race);
	public int getSpecial();
	public void setSpecial(int newSpec);
	public void changeSpecial(int deltaSpec);
	public int getTotalBonus();
	public String toString();
	public void statGain(int stat, int d10first, int d10second);
}
