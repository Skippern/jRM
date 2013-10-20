package org.gimnechiske.jRM.lib;

public class RMSystem {
	public static final int MESSAGE_ERROR = 0; // Error messages
	public static final int MESSAGE_SYSTEM = 1; // System, connection, etc
	public static final int MESSAGE_SERVER = 2; // Chat from server, status updates
	public static final int MESSAGE_SHUTDOWN = 3; // Game shutdown
	public static final int MESSAGE_GAMEMASTER = 4; // Gamemaster chat - gamemaster->game - gamemaster->player
	public static final int MESSAGE_GAME = 5; // Game chat
	public static final int MESSAGE_PLAYER = 6; // Player->game - player->gamemaster
	public static final int MESSAGE_CHARACTER = 7; // Character actions, talk, etc
	public static final int MESSAGE_NPC = 8; // NPC actions, talk, etc
	public static final int MESSAGE_STORYLINE = 9; // Storyline events
	public static final int MESSAGE_MONSTER = 10; // Monster actions
	public static final int MESSAGE_COMBAT = 11; // Combat events, damage
	public static final int MESSAGE_MAGIC = 12; // Magic casting, effects, etc
	public static final int MESSAGE_SKILL = 13; // Skill resolution, results
	public static final int MESSAGE_ENVIRONMENT = 14; // Weather, background noise, etc
	public static final int MESSAGE_TICK = 15; // Ticker (include bleed, recovery, etc)
	public static final int MESSAGE_DING = 16; // DING! Character level up
	public static final int MESSAGE_ENCOUNTER = 17; // Random encounters, etc
	public static final int MESSAGE_TRADE = 18; // Trading (items, value, quality, info)
	public static final int MESSAGE_HERBS = 19; // Herb effects, etc
	public static final int MESSAGE_CONSTRUCT = 20; // Androids, constructs, golems, gargoyls, etc
	public static final int MESSAGE_DICE = 21; // Dice rolls
}
