package org.gimnechiske.jRM.lib;

public class Progression {
	/* Used in some Skill categories */
	public static final double[] NONE = { 0.0, 0.0, 0.0, 0.0, 0.0 };
	/* Skill progression */
	public static final double[] CATEGORY = { -15.0, 2.0, 1.0, 0.5, 0.0 };
	public static final double[] STANDARD = { -15.0, 3.0, 2.0, 1.0, 0.5 };
	public static final double[] COMBINED = { -30.0, 5.0, 3.0, 1.5, 0.5 };
	/* Special Skill Progressions, even though same, they are separated
	 * in case special rules are needed to prevent broken code */
	public static final double[] LIMITED = { 0.0, 1.0, 1.0, 0.5, 0.0 };
	public static final double[] SPELLS  = { -30.0, 1.0, 1.0, 0.5, 0.0 };
	/* Body Development Skill Progression, defined by race */
	public static final double[] BODY0  = { 0.0, 0.0, 0.0, 0.0, 0.0 };//Androids
	public static final double[] BODY1  = { 0.0, 6.0, 2.0, 2.0, 1.0 };// -17
	public static final double[] BODY2  = { 0.0, 6.0, 3.0, 1.0, 1.0 };// -15
	public static final double[] BODY3  = { 0.0, 6.0, 3.0, 2.0, 1.0 };// -10
	public static final double[] BODY4  = { 0.0, 6.0, 4.0, 2.0, 1.0 };// 0
	public static final double[] BODY5  = { 0.0, 7.0, 3.0, 2.0, 1.0 };// 5
	public static final double[] BODY6  = { 0.0, 6.0, 5.0, 2.0, 1.0 };// 10
	public static final double[] BODY7  = { 0.0, 7.0, 4.0, 2.0, 1.0 };// 13
	public static final double[] BODY8  = { 0.0, 7.0, 5.0, 2.0, 1.0 };// 14
	public static final double[] BODY9  = { 0.0, 7.0, 5.0, 3.0, 1.0 };// 15
	public static final double[] BODY10 = { 0.0, 10.0, 7.0, 5.0, 4.0 };//
	public static final double[] BODY11 = { 0.0, 10.0, 8.0, 6.0, 4.0 };//
	public static final double[] BODY12 = { 0.0, 11.0, 10.0, 9.0, 1.0 };// 30
	public static final double[] BODY13 = { 0.0, 15.0, 13.0, 7.0, 1.0 };// 35
	/* Power Point Skill Progression, defined by race and realm of Power */
	public static final double[] SPELL0 = { 0.0, 0.0, 0.0, 0.0, 0.0 };//No spell
	public static final double[] SPELL1 = { 0.0, 2.0, 1.0, 1.0, 1.0 };//
	public static final double[] SPELL2 = { 0.0, 3.0, 2.0, 1.0, 1.0 };//
	public static final double[] SPELL3 = { 0.0, 4.0, 3.0, 2.0, 1.0 };//
	public static final double[] SPELL4 = { 0.0, 5.0, 3.0, 2.0, 2.0 };//
	public static final double[] SPELL5 = { 0.0, 6.0, 4.0, 3.0, 2.0 };//
	public static final double[] SPELL6 = { 0.0, 6.0, 5.0, 4.0, 3.0 };//
	public static final double[] SPELL7 = { 0.0, 6.0, 6.0, 4.0, 3.0 };//
	public static final double[] SPELL8 = { 0.0, 7.0, 6.0, 5.0, 4.0 };//
	/* Mind Power Skill Progression, defined by race */
	public static final double[] MIND0  = { 0.0, 0.0, 0.0, 0.0, 0.0 };//no mind power
	public static final double[] MIND1  = { 0.0, 2.0, 1.0, 1.0, 1.0 };//
	public static final double[] MIND2  = { 0.0, 3.0, 2.0, 1.0, 1.0 };//
	public static final double[] MIND3  = { 0.0, 4.0, 3.0, 2.0, 1.0 };//
	public static final double[] MIND4  = { 0.0, 5.0, 3.0, 2.0, 2.0 };//
	public static final double[] MIND5  = { 0.0, 6.0, 4.0, 3.0, 2.0 };//
	public static final double[] MIND6  = { 0.0, 6.0, 5.0, 3.0, 2.0 };//
	public static final double[] MIND7  = { 0.0, 6.0, 6.0, 4.0, 3.0 };//
	public static final double[] MIND8  = { 0.0, 7.0, 6.0, 5.0, 4.0 };//
	public static final double[] MIND9  = { 0.0, 8.0, 7.0, 6.0, 5.0 };//
	public static final double[] MIND10 = { 0.0, 11.0, 10.0, 9.0, 6.0 };//
}
