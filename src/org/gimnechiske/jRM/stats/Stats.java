package org.gimnechiske.jRM.stats;

import org.gimnechiske.jRM.core.Stat;
import org.gimnechiske.jRM.lib.*;

public class Stats {
	private Agility ag = new Agility();
	private Constitution co = new Constitution();
	private Memory me = new Memory();
	private Reasoning re = new Reasoning();
	private SelfDiscipline sd = new SelfDiscipline();
	private Empathy em = new Empathy();
	private Intuition in = new Intuition();
	private Presence pr = new Presence();
	private Quickness qu = new Quickness();
	private Strength st = new Strength();
	private String[] statsNames;
	private String[] statsDescription;
	private int[] statsTemp;
	private int[] statsPot;
	private int[] statsBasicBonus;
	private int[] statsRacialBonus;
	private int[] statsSpecialBonus;
	private int[] statsTotalBonus;
	private Stat[] allStats = { ag, co, me, re, sd, em, in, pr, qu, st };

	public Stats() {
		refresh();
	}
	private void refresh() {
		statsNames[LibStats.AG] = ag.getName();
		statsDescription[LibStats.AG] = ag.getDescription();
		statsTemp[LibStats.AG] = ag.getTemp();
		statsPot[LibStats.AG] = ag.getPot();
		statsBasicBonus[LibStats.AG] = ag.getBasicBonus();
		statsRacialBonus[LibStats.AG] = ag.getRacialBonus();
		statsSpecialBonus[LibStats.AG] = ag.getSpecial();
		statsTotalBonus[LibStats.AG] = ag.getTotalBonus();
		statsNames[LibStats.CO] = co.getName();
		statsDescription[LibStats.CO] = co.getDescription();
		statsTemp[LibStats.CO] = co.getTemp();
		statsPot[LibStats.CO] = co.getPot();
		statsBasicBonus[LibStats.CO] = co.getBasicBonus();
		statsRacialBonus[LibStats.CO] = co.getRacialBonus();
		statsSpecialBonus[LibStats.CO] = co.getSpecial();
		statsTotalBonus[LibStats.CO] = co.getTotalBonus();
		statsNames[LibStats.ME] = me.getName();
		statsDescription[LibStats.ME] = me.getDescription();
		statsTemp[LibStats.ME] = me.getTemp();
		statsPot[LibStats.ME] = me.getPot();
		statsBasicBonus[LibStats.ME] = me.getBasicBonus();
		statsRacialBonus[LibStats.ME] = me.getRacialBonus();
		statsSpecialBonus[LibStats.ME] = me.getSpecial();
		statsTotalBonus[LibStats.ME] = me.getTotalBonus();
		statsNames[LibStats.RE] = re.getName();
		statsDescription[LibStats.RE] = re.getDescription();
		statsTemp[LibStats.RE] = re.getTemp();
		statsPot[LibStats.RE] = re.getPot();
		statsBasicBonus[LibStats.RE] = re.getBasicBonus();
		statsRacialBonus[LibStats.RE] = re.getRacialBonus();
		statsSpecialBonus[LibStats.RE] = re.getSpecial();
		statsTotalBonus[LibStats.RE] = re.getTotalBonus();
		statsNames[LibStats.SD] = sd.getName();
		statsDescription[LibStats.SD] = sd.getDescription();
		statsTemp[LibStats.SD] = sd.getTemp();
		statsPot[LibStats.SD] = sd.getPot();
		statsBasicBonus[LibStats.SD] = sd.getBasicBonus();
		statsRacialBonus[LibStats.SD] = sd.getRacialBonus();
		statsSpecialBonus[LibStats.SD] = sd.getSpecial();
		statsTotalBonus[LibStats.SD] = sd.getTotalBonus();
		statsNames[LibStats.EM] = em.getName();
		statsDescription[LibStats.EM] = em.getDescription();
		statsTemp[LibStats.EM] = em.getTemp();
		statsPot[LibStats.EM] = em.getPot();
		statsBasicBonus[LibStats.EM] = em.getBasicBonus();
		statsRacialBonus[LibStats.EM] = em.getRacialBonus();
		statsSpecialBonus[LibStats.EM] = em.getSpecial();
		statsTotalBonus[LibStats.EM] = em.getTotalBonus();
		statsNames[LibStats.IN] = in.getName();
		statsDescription[LibStats.IN] = in.getDescription();
		statsTemp[LibStats.IN] = in.getTemp();
		statsPot[LibStats.IN] = in.getPot();
		statsBasicBonus[LibStats.IN] = in.getBasicBonus();
		statsRacialBonus[LibStats.IN] = in.getRacialBonus();
		statsSpecialBonus[LibStats.IN] = in.getSpecial();
		statsTotalBonus[LibStats.IN] = in.getTotalBonus();
		statsNames[LibStats.PR] = pr.getName();
		statsDescription[LibStats.PR] = pr.getDescription();
		statsTemp[LibStats.PR] = pr.getTemp();
		statsPot[LibStats.PR] = pr.getPot();
		statsBasicBonus[LibStats.PR] = pr.getBasicBonus();
		statsRacialBonus[LibStats.PR] = pr.getRacialBonus();
		statsSpecialBonus[LibStats.PR] = pr.getSpecial();
		statsTotalBonus[LibStats.PR] = pr.getTotalBonus();
		statsNames[LibStats.QU] = qu.getName();
		statsDescription[LibStats.QU] = qu.getDescription();
		statsTemp[LibStats.QU] = qu.getTemp();
		statsPot[LibStats.QU] = qu.getPot();
		statsBasicBonus[LibStats.QU] = qu.getBasicBonus();
		statsRacialBonus[LibStats.QU] = qu.getRacialBonus();
		statsSpecialBonus[LibStats.QU] = qu.getSpecial();
		statsTotalBonus[LibStats.QU] = qu.getTotalBonus();
		statsNames[LibStats.ST] = st.getName();
		statsDescription[LibStats.ST] = st.getDescription();
		statsTemp[LibStats.ST] = st.getTemp();
		statsPot[LibStats.ST] = st.getPot();
		statsBasicBonus[LibStats.ST] = st.getBasicBonus();
		statsRacialBonus[LibStats.ST] = st.getRacialBonus();
		statsSpecialBonus[LibStats.ST] = st.getSpecial();
		statsTotalBonus[LibStats.ST] = st.getTotalBonus();
	}
	
	public Stat getStat(int stat) {
		return allStats[stat];
	}
	public String getName(int stat) {
		return statsNames[stat];
	}
	public String getDescription(int stat) {
		return statsDescription[stat];
	}
	public int getTemp(int stat) {
		return statsTemp[stat];
	}
	public int getPot(int stat) {
		return statsPot[stat];
	}
	public int getBasicBonus(int stat) {
		return statsBasicBonus[stat];
	}
	public int getRacialBonus(int stat) {
		return statsRacialBonus[stat];
	}
	public int getSpecialBonus(int stat) {
		return statsSpecialBonus[stat];
	}
	public int getTotalBonus(int stat) {
		return statsTotalBonus[stat];
	}
	public int getDevelopmentPoints() {
		return (int) (getTemp(LibStats.AG) + getTemp(LibStats.CO) + 
				getTemp(LibStats.ME) + getTemp(LibStats.RE) + 
				getTemp(LibStats.SD)) / 5;
	}
}
