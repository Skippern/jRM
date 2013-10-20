package org.gimnechiske.jRM.professions;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.core.SkillCategory;
import org.gimnechiske.jRM.lib.*;

public class Criminal implements Profession {
	private int[] primeStats = { LibStats.AG, LibStats.QU }; 
	private Skill[] everymanSkill;
	private Skill[] occupationalSkill;
	private Skill[] restrictedSkill;
	
	public int[] getPrimeStats() {
		return primeStats;
	}

	public String getName() {
		return "Criminal";
	}

	public String getDescription() {
		return "Criminals are masters of deciet and subtlety. The " +
				"futuristic Criminal must also be a technical wizard " +
				"as well. They must be able to hack a system or run " +
				"a bypass better than any other person, or they're " +
				"out of job. The futuristic Criminal must be a master " +
				"of technology, at least as far as it relates to " +
				"security systems.";
	}

	public int getRealm() {
		return Realms.ARMS;
	}
	public int getRealm2() {
		return Realms.SUBTERFUGE;
	}

	public int[] getDevCost(SkillCategory sc) {
		int[] tmp = { 0, 0, 0 };
		String n = sc.getName();
		
		if (sc.getGroup() == "Weapon") {
			// Arrange weapons according to chose by character
		}
		else if (sc.getGroup() == "Psychic") {
			// Arrange psychic categories according to chose by character
		}
		
		switch (n) {
		case "Armor * Heavy":
			tmp[0] = 4;
			tmp[1] = 4;
			tmp[2] = 4;
			break;
		case "Armor * Light":
			tmp[0] = 2;
			tmp[1] = 2;
			tmp[2] = 2;
			break;
		case "Armor * Medium":
			tmp[0] = 3;
			tmp[1] = 3;
			tmp[2] = 3;
			break;
		case "Artistic * Active":
			tmp[0] = 2;
			tmp[1] = 4;
			break;
		case "Artistic * Passive":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Athletic * Brawn":
			tmp[0] = 3;
			tmp[1] = 6;
			break;
		case "Athletic * Endurance":
			tmp[0] = 2;
			tmp[1] = 7;
			break;
		case "Athletic * Gymnastic":
			tmp[0] = 1;
			tmp[1] = 3;
			break;
		case "Awareness * Perception":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Awareness * Searching":
			tmp[0] = 1;
			tmp[1] = 3;
			break;
		case "Awareness * Senses":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Body Development":
			tmp[0] = 5;
			tmp[1] = 12;
			break;
		case "Combat Maneuvers":
			tmp[0] = 4;
			tmp[1] = 12;
			break;
		case "Communications":
			tmp[0] = 2;
			tmp[1] = 2;
			tmp[2] = 2;
			break;
		case "Crafts":
			tmp[0] = 4;
			tmp[1] = 10;
			break;
		case "Directed Spells":
			tmp[0] = 20;
			break;
		case "Influence":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Lore * Academic":
			tmp[0] = 1;
			tmp[1] = 5;
			break;
		case "Lore * General":
			tmp[0] = 1;
			tmp[1] = 3;
			break;
		case "Lore * Magical":
			tmp[0] = 5;
			break;
		case "Lore * Obscure":
			tmp[0] = 3;
			tmp[1] = 7;
			break;
		case "Lore * Technical":
			tmp[0] = 2;
			tmp[1] = 4;
			break;
		case "Martial Arts * Combat Maneuvers":
			tmp[0] = 5;
			break;
		case "Martial Arts * Striking":
			tmp[0] = 3;
			tmp[1] = 7;
			break;
		case "Mind Point Development":
			tmp[0] = 20;
			break;
		case "Outdoor * Animal":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Outdoor * Environmental":
			tmp[0] = 2;
			tmp[1] = 5;
			break;
		case "Power Awareness":
			tmp[0] = 6;
			break;
		case "Power Manipulation":
			tmp[0] = 18;
			break;
		case "Power Point Development":
			tmp[0] = 15;
			break;
		case "Psychic * Category 1":
			tmp[0] = 50;
			break;
		case "Psychic * Category 2":
			tmp[0] = 75;
			break;
		case "Psychic * Category 3":
			tmp[0] = 100;
			break;
		case "Psychic * Category 4":
			tmp[0] = 125;
			break;
		case "Psychic * Category 5":
			tmp[0] = 150;
			break;
		case "Psychic * Category 6+":
			tmp[0] = 175;
			break;
		case "Science/Analytic * Basic":
			tmp[0] = 3;
			tmp[1] = 6;
			break;
		case "Science/Analytic * Engineering":
			tmp[0] = 8;
			break;
		case "Science/Analytic * Medical":
			tmp[0] = 8;
			break;
		case "Science/Analytic * Specialized":
			tmp[0] = 10;
			break;
		case "Science/Analytic * Technical":
			tmp[0] = 6;
			tmp[1] = 12;
			break;
		case "Self Control":
			tmp[0] = 2;
			tmp[1] = 6;
			break;
		case "Special Attacks":
			tmp[0] = 2;
			tmp[1] = 8;
			break;
		case "Subterfuge * Attack":
			tmp[0] = 2;
			tmp[1] = 6;
			break;
		case "Subterfuge * Mechanics":
			tmp[0] = 1;
			tmp[1] = 3;
			break;
		case "Subterfuge * Stealth":
			tmp[0] = 1;
			tmp[1] = 3;
			break;
		case "Technical/Trade * General":
			tmp[0] = 2;
			tmp[1] = 6;
			break;
		case "Technical/Trade * Gunnery":
			tmp[0] = 6;
			break;
		case "Technical/Trade * Professional":
			tmp[0] = 6;
			break;
		case "Technical/Trade * Vehicles":
			tmp[0] = 5;
			break;
		case "Technical/Trade * Vocational":
			tmp[0] = 3;
			tmp[1] = 9;
			break;
		case "Urban":
			tmp[0] = 1;
			tmp[1] = 2;
			break;
		case "Weapon * Category 1":
			tmp[0] = 2;
			tmp[1] = 7;
			break;
		case "Weapon * Category 2":
			tmp[0] = 3;
			tmp[1] = 8;
			break;
		case "Weapon * Category 3":
			tmp[0] = 4;
			break;
		case "Weapon * Category 4":
			tmp[0] = 4;
			break;
		case "Weapon * Category 5":
			tmp[0] = 4;
			break;
		case "Weapon * Category 6":
			tmp[0] = 6;
			break;
		case "Weapon * Category 7":
			tmp[0] = 6;
			break;
		case "Weapon * Category 8":
			tmp[0] = 6;
			break;
		case "Weapon * Category 9":
			tmp[0] = 6;
			break;
		case "Weapon * Category 10":
			tmp[0] = 6;
			break;
		case "Weapon * Category 11":
			tmp[0] = 6;
			break;
		case "Weapon * Category 12":
			tmp[0] = 6;
			break;
		default:
			tmp = null;
		}
		
		return tmp;
	}

	public int getProfessionBonus(SkillCategory sc) {
		int tmp;
		String n = sc.getName();
		if (sc.getGroup() == "Awareness") n = "Awareness";
		else if (sc.getGroup() == "Weapon") n = "Weapon";
		else if (sc.getGroup() == "Subterfuge") n = "Subterfuge";
		switch (n) {
		case "Athletic * Gymnastic":
		case "Self Control":
			tmp = 5;
			break;
		case "Awareness":
		case "Weapon":
			tmp = 10;
			break;
		case "Subterfuge":
			tmp = 15;
			break;
		default:
			tmp = 0;
		}
		
		return tmp;
	}

	public Skill[] getEverymanSkills() {
		return everymanSkill;
	}
	public Skill[] getOccupationalSkills() {
		return occupationalSkill;
	}
	public Skill[] getRestrictedSkills() {
		return restrictedSkill;
	}
	public boolean isEverymanSkill(Skill s) {
		for (int i = 0; i < everymanSkill.length; i++) {
			if (everymanSkill[i] == s) return true;
		}
		return false;
	}
	public boolean isOccupationalSkill(Skill s) {
		for (int i = 0; i < occupationalSkill.length; i++) {
			if (occupationalSkill[i] == s) return true;
		}
		return false;
	}
	public boolean isRestrictedSkill(Skill s) {
		for (int i = 0; i < restrictedSkill.length; i++) {
			if (restrictedSkill[i] == s) return true;
		}
		return false;
	}
}
