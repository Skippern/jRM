package org.gimnechiske.jRM.lib;

import java.lang.Math;
/**
 * 
 * @author Aun Johnsen
 *
 * A bag of dice, that is called whenever a dice roll is needed
 */
public class Dice {
	public Dice() {
		
	}
	/**
	 * 
	 * This function is kept internal, this is the real dice roll,
	 * the various d##() functions is place holders representing the
	 * various dices, visible for the application. It is done this
	 * way to force use of standard dice.
	 * 
	 * @param dice
	 * @return dice result
	 */
	private int rollDice(int dice) {
		return (int) Math.round( (float) (Math.random() * dice));
	}
	
	public int d3() {
		return rollDice(3);
	}
	public int d4() {
		return rollDice(4);
	}
	public int d5() {
		return rollDice(5);
	}
	public int d6() {
		return rollDice(6);
	}
	public int d8() {
		return rollDice(8);
	}
	public int d10() {
		return rollDice(10);
	}
	public int d12() {
		return rollDice(12);
	}
	public int d20() {
		return rollDice(20);
	}
	public int d100() {
		return rollDice(100);
	}
	public int[] dPercent() {
		int[] tmp = { d10(), d10() };
		return tmp;
	}
}
