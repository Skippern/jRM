package org.gimnechiske.jRM.races;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.lib.*;

public class HumanMixed implements Race {
	public String getName() {
		return "Human (Mixed)";
	}
	public String getDescription() {
		return "";
	}
	public int[] getRaceStats() {
		int[] tmp = {};
		tmp[LibStats.AG] = 0;
		tmp[LibStats.CO] = 2;
		tmp[LibStats.ME] = 0;
		tmp[LibStats.RE] = 0;
		tmp[LibStats.SD] = 2;
		tmp[LibStats.EM] = 2;
		tmp[LibStats.IN] = 0;
		tmp[LibStats.PR] = 2;
		tmp[LibStats.QU] = 0;
		tmp[LibStats.ST] = 2;
		return tmp;
	}
	public int[] getRRMods() {
		int[] i = {};
		i[Resistance.POISON] = 0;
		i[Resistance.DISEASE] = 0;
		i[Resistance.ESSENCE] = 0;
		i[Resistance.CHANNELING] = 0;
		i[Resistance.MENTALISM] = 0;
		return i;
	}
	public double[] getBodyDev() {
		return Progression.BODY4;
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
		return 4;
	}
	public int getSiegeLevel() {
		return 3;
	}
	public int getTrapBuildingLevel() {
		return 3;
	}
	public int getTechnologyLevel() {
		return 7;
	}
	public double getLaborEffectiveness() {
		return 1.0;
	}
}
