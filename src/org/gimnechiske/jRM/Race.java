package org.gimnechiske.jRM;

public interface Race {
	public String getName();
	public String getDescription();
	public int[] getRaceStats();
	public int[] getRRMods();
	public double[] getBodyDev();
	public double[] getPPDev(int realm);
	public double[] getPsychicDev();
	public int getSoulDeparture();
	public double getRecoveryModifier();
	public int getRaceType();
	public int getArchitectLevel();
	public int getSiegeLevel();
	public int getTrapBuildingLevel();
	public int getTechnologyLevel();
	public double getLaborEffectiveness();
}
