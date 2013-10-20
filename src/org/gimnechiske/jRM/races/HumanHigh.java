package org.gimnechiske.jRM.races;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.lib.*;

public class HumanHigh implements Race {
	public String getName() {
		return "Human (High)";
	}
	public String getDescription() {
		return "High Men are great warriors and builders of empires, for " +
				"their initiative matches their physical stature. They " +
				"are said to have traces of Elven blood and maybe even a " +
				"little blood of gods.";
	}
	public int[] getRaceStats() {
		int[] tmp = {};
		tmp[LibStats.AG] = -2;
		tmp[LibStats.CO] = 4;
		tmp[LibStats.ME] = 0;
		tmp[LibStats.RE] = 0;
		tmp[LibStats.SD] = 0;
		tmp[LibStats.EM] = 0;
		tmp[LibStats.IN] = 0;
		tmp[LibStats.PR] = 4;
		tmp[LibStats.QU] = -2;
		tmp[LibStats.ST] = 4;
		return tmp;
	}
	public int[] getRRMods() {
		int[] i = {};
		i[Resistance.POISON] = 0;
		i[Resistance.DISEASE] = 0;
		i[Resistance.ESSENCE] = -5;
		i[Resistance.CHANNELING] = -5;
		i[Resistance.MENTALISM] = -5;
		return i;
	}
	public double[] getBodyDev() {
		return Progression.BODY9;
	}
	public double[] getPPDev(int realm) {
		switch (realm) {
		case Realms.CHANNELING:
			return Progression.SPELL6;
		case Realms.ESSENCE:
			return Progression.SPELL6;
		case Realms.MENTALISM:
			return Progression.SPELL8;
		case Realms.ARCANE:
			return Progression.SPELL6;
		default:
			return Progression.SPELL0;
		}
	}
	public double[] getPsychicDev() {
		return Progression.MIND0;
	}
	public int getSoulDeparture() {
		return 12;
	}
	public double getRecoveryModifier() {
		return 1;
	}
	public int getRaceType() {
		return 2;
	}
	public int getArchitectLevel() {
		return 7;
	}
	public int getSiegeLevel() {
		return 7;
	}
	public int getTrapBuildingLevel() {
		return 6;
	}
	public int getTechnologyLevel() {
		return 8;
	}
	public double getLaborEffectiveness() {
		return 0.95;
	}
}
