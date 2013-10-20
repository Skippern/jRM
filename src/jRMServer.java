import org.gimnechiske.jRM.ServerApp;
/**
 * 
 * @author Aun Johnsen
 *
 * The server application should accept rmi:// connections, and let GM's
 * invite players. A GM must have invite open for players to join. A GM
 * may accept or reject players. - The server only negotiates connection
 * between a GM and several players, transferring objects, queries, chat,
 * etc between the GM and the players.
 * 
 * A single server should be able to host multiple games at one single time,
 * and GM's might have a separate chat outside the game with other GM's, a
 * useful tool for advice.
 */
public class jRMServer extends ServerApp {
	private static final long serialVersionUID = 1L;
}
