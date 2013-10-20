package org.gimnechiske.jRM.lib;

public class Spells {
	/* Spell List types */
	public static final int OPEN = 0; // Open Lists
	public static final int CLOSED = 1; // Closed Lists
	public static final int BASE = 2; // Base spells (Profession)
	public static final int EVIL = 3; // Evil spells
	public static final int HOLY = 4; // Holy spells
	public static final int RACE = 5; // Race spells
	public static final int TP = 6; // Training Package
	/* Spell Types */
	public static final int TYPE_E = 0; // Elemental spells
	public static final int TYPE_BE = 1; // Ball Elemental spells
	public static final int TYPE_DE = 2; // Directed Elemental spells
	public static final int TYPE_F = 3; // Force spells
	public static final int TYPE_P = 4; // Passive spells
	public static final int TYPE_U = 5; // Utility spells
	public static final int TYPE_I = 6; // Informational spells
	/* Spell Subtypes */
	public static final int SUBTYPE_s = 0; // Subconscious spells
	public static final int SUBTYPE_m = 1; // Mental Attack Spells
	public static final int SUBTYPE_v = 2; // Vestment spells (#5601)
	/* Spell Failure */
	public static final int SPELL_FAILURE = 0;
	public static final int SPELL_FAILURE_ARCANE_ELEMENTAL = 1;
	public static final int SPELL_FAILURE_ARCANE_OTHER = 2;
	/* Mind Power Types */
	public static final int MIND_D = 0; // Direct attack
	public static final int MIND_E = 1; // Energy
	public static final int MIND_F = 2; // Force
	public static final int MIND_P = 3; // Passive
	public static final int MIND_U = 4; // Utility
	/* Psychic Failure */
	public static final int PSYCHIC_FAILURE_DIRECTED_ATTACK = 21;
	public static final int PSYCHIC_FAILURE_BASIC_ATTACK = 22;
	public static final int PSYCHIC_FAILURE_INFORMATION = 23;
	public static final int PSYCHIC_FAILURE_OTHER = 24;
}
