package org.gimnechiske.jRM.stats;

import org.gimnechiske.jRM.core.Stat;

public class Reasoning implements Stat {
	private int temp;
	private int pot;
	private int special;
	
	public int getTemp() {
		return temp;
	}
	public int getPot() {
		return pot;
	}
	public int getBasicBonus() {
		int temp = getTemp();
		if (temp > 101) return 14;
		switch (temp) {
			case 1:
				return -10;
			case 2:
			case 3:
				return -9;
			case 4:
			case 5:
				return -8;
			case 6:
			case 7:
				return -7;
			case 8:
			case 9:
				return -6;
			case 10:
				return -5;
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
				return -4;
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				return -3;
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
				return -2;
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
				return -1;
			case 70:
			case 71:
			case 72:
			case 73:
			case 74:
				return 1;
			case 75:
			case 76:
			case 77:
			case 78:
			case 79:
				return 2;
			case 80:
			case 81:
			case 82:
			case 83:
			case 84:
				return 3;
			case 85:
			case 86:
			case 87:
			case 88:
			case 89:
				return 4;
			case 90:
			case 91:
				return 5;
			case 92:
			case 93:
				return 6;
			case 94:
			case 95:
				return 7;
			case 96:
			case 97:
				return 8;
			case 98:
			case 99:
				return 9;
			case 100:
				return 10;
			case 101:
				return 12;
			default:
				return 0;
		}
	}
	public int getRacialBonus() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getSpecial() {
		return special;
	}
	public int getTotalBonus() {
		return getBasicBonus() + getRacialBonus() + getSpecial();
	}
	public String getName() {
		return "Reasoning";
	}
	public String getDescription() {
		String desc = "Similar to intelligence: the ability to absorb, " +
				"comprehend, and categorize data for future use. It also " +
				"reflects the ability to take available information and " +
				"draw logical conclusions. Also referred to as: " +
				"intelligence, learning ability, study ability, analysis " +
				"rating, mental quickness, logic, deductive capability, " +
				"wit, judgement, I.Q., etc.";
		return desc;
	}
	public String getShortName() {
		return "Re";
	}
	public void setTemp(int newTemp) {
		temp = newTemp;
	}
	public void setPot(int newPot) {
		pot = newPot;
	}
	public void setSpecial(int newSpec) {
		special = newSpec;
	}
	public void changeSpecial(int deltaSpec) {
		special += deltaSpec;
	}
	public void statGain(int stat, int d10first, int d10second) {
		int diff = pot - temp;
		int mod;
		
		if (diff <= 10) { // difference less than or equal 10 (low die)
			if (d10first == d10second) {
				if (d10first < 6) mod = -d10first;
				else mod = d10first + d10second;
			}
			else if ( d10first < d10second) mod = d10first;
			else mod = d10second;
		}
		else if (diff > 20) { // difference greater than 20 (sum of dice)
			if (d10first == d10second) {
				if (d10first < 6) mod = -d10first;
				else mod = d10first + d10second;
			}
			else mod = d10first + d10second;
		}
		else { // difference greater than 10, but less than or equals 20 (high die)
			if (d10first == d10second) {
				if (d10first < 6) mod = -d10first;
				else mod = d10first + d10second;
			}
			else if ( d10first > d10second) mod = d10first;
			else mod = d10second;
		}
		mod += temp;
		if (mod > pot) temp = pot; // temp cannot be larger than pot
		else temp = mod; // setting temp with new value
	}
}
