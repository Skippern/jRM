package org.gimnechiske.jRM.races;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.lib.*;

public class HumanFuture implements Race {
	public String getName() {
		return "Human (Future)";
	}
	public String getDescription() {
		return "Humans are rash and curious. They tend to be one of " +
				"the primary motivators in known space, mainly because " +
				"of their charisma and thier ability to charm others " +
				"into following their damn-fool crusades.\n" +
				"Humans from various worlds have tried many eugenics " +
				"and genetics programs to increase the quality of their " +
				"stock. For the most part, these effects have been " +
				"equalized through inbreeding to the stat bonuses shown";
	}
	public int[] getRaceStats() {
		int[] tmp = {};
		tmp[LibStats.AG] = 2;
		tmp[LibStats.CO] = 2;
		tmp[LibStats.ME] = 2;
		tmp[LibStats.RE] = 2;
		tmp[LibStats.SD] = 2;
		tmp[LibStats.EM] = 2;
		tmp[LibStats.IN] = 2;
		tmp[LibStats.PR] = 2;
		tmp[LibStats.QU] = 2;
		tmp[LibStats.ST] = 2;
		return tmp;
	}
	public int[] getRRMods() {
		int[] i = {};
		i[Resistance.POISON] = 0;
		i[Resistance.DISEASE] = 0;
		i[Resistance.FEAR] = 0;
		i[Resistance.PSYCHIC] = 0;
		return i;
	}
	public double[] getBodyDev() {
		return Progression.BODY6;
	}
	public double[] getPPDev(int realm) {
		return Progression.SPELL0;
	}
	public double[] getPsychicDev() {
		return Progression.MIND8;
	}
	public int getSoulDeparture() {
		return 12;
	}
	public double getRecoveryModifier() {
		return 0.9;
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
		return 18;
	}
	public double getLaborEffectiveness() {
		return 1.0;
	}
}
