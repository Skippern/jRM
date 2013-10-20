package org.gimnechiske.jRM.races;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.lib.*;

public class HumanModern implements Race {
	public String getName() {
		return "Human (Modern)";
	}
	public String getDescription() {
		return "";
	}
	public int[] getRaceStats() {
		int[] tmp = {};
		tmp[LibStats.AG] = 0;
		tmp[LibStats.CO] = 0;
		tmp[LibStats.ME] = 0;
		tmp[LibStats.RE] = 2;
		tmp[LibStats.SD] = 0;
		tmp[LibStats.EM] = 0;
		tmp[LibStats.IN] = 0;
		tmp[LibStats.PR] = 0;
		tmp[LibStats.QU] = 0;
		tmp[LibStats.ST] = 2;
		return tmp;
	}
	public int[] getRRMods() {
		int[] i = {};
		i[Resistance.POISON] = 0;
		i[Resistance.DISEASE] = 0;
		return i;
	}
	public double[] getBodyDev() {
		return Progression.BODY4;
	}
	public double[] getPPDev(int realm) {
		switch (realm) {
		case Realms.ARCANE:
		case Realms.ESSENCE:
		case Realms.CHANNELING:
		case Realms.MENTALISM:
			return Progression.SPELL1;
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
		return 1;
	}
	public int getSiegeLevel() {
		return 1;
	}
	public int getTrapBuildingLevel() {
		return 1;
	}
	public int getTechnologyLevel() {
		return 15;
	}
	public double getLaborEffectiveness() {
		return 1.0;
	}
}
