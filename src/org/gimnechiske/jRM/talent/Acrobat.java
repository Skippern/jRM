package org.gimnechiske.jRM.talent;

import org.gimnechiske.jRM.Talent;
import org.gimnechiske.jRM.lib.*;

public class Acrobat implements Talent {
	public String getName() {
		return "Acrobat";
	}
	public String getDescription() {
		String tmp = "You received a special bonus of +15 to your " + 
				"Athletic �? Gymnastics skill Category. You also " +
				"receive a special bonus of +25 to a Special Attack " +
				"skill that doesn't use a weapon";
		return tmp;
	}
	public int getType() {
		return Talents.SPECIALTRAINING;
	}
	public int getCost() {
		return 7;
	}
}
