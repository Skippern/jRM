package org.gimnechiske.jRM.lib;

public class Realms {
	/* Default Realm */
	public static final int ARMS = 0; // Stat.CO
	/* Realms of Power */
	public static final int CHANNELING = 1; // Stat.IN
	public static final int ESSENCE = 2; // Stat.EM
	public static final int MENTALISM = 3; // Stat.PR
	public static final int ARCANE = 4; // Stat.IN + Stat.EM + Stat.PR
	/* Spacemaster special realm (Psychic powers in sci-fi/Psionic 
	 * powers in  fantasy) */
	public static final int PSYCHIC = 5; // Stat.SD + Stat.PR
	/* Not really visible, available to calculate
	 * Profession costs and game balance */
	public static final int MUNDANE = 6; // Stat.(none)
	public static final int DISCIPLINE = 7; // Stat.SD
	public static final int SUBTERFUGE = 8; // Stat.AG
	public static final int DIVINE = 9; // Stat.IN
	/* Special rule for TP and Racial spells */
	public static final int GENERAL = 10; // Spells "without" realm
	public static final int TRAININGPACKAGE = 11; // spells considered BASE
	public static final int RACE = 12; // Spells considered BASE
}
