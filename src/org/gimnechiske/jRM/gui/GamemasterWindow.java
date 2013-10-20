package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.rmi.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.gui.map.Map;

/**
 * 
 * @author Aun Johnsen
 *
 * The Gamemaster Window is the GUI of the GamemasterApp, and much of the
 * functionality of the Gamemaster is placed here.
 * 
 * Each different sub-window should be created as separate classes, and
 * added here, either as self-starting, parts of menus, or through special
 * calls from other windows.
 */
public class GamemasterWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane background;
	
	private Gamemaster gm;
	private RMServer server;
	private static ArrayList<Map> maps = new ArrayList<>();

	static JMenuItem menuFileNewGame = new JMenuItem("New Game");
	static JMenuItem menuFileOpenGame = new JMenuItem("Open Game");
	static JMenuItem menuFileCloseGame = new JMenuItem("Close Game");
	static JMenuItem menuFileConnect = new JMenuItem("Connect");
	static JMenuItem menuFileDisconnect = new JMenuItem("Disconnect");
	static JMenu menuGame = new JMenu("Game");
	static JMenuItem menuGameStartGame = new JMenuItem("Start Game");
	static JMenuItem menuGameOpenInvite = new JMenuItem("Open Invite");
	static JMenuItem menuGameCloseInvite = new JMenuItem("Close Invite");

	public GMChatFrame gmChat;

	JFileChooser o = null;
	
	public GamemasterWindow(Gamemaster gm, RMServer server)
			throws RemoteException, Exception {
		this.gm = gm;
		this.server = server;
		addWindowListener(new WindowCloseListener());
		if (gm != null) setTitle("jRM Gamemaster: " + gm.getName());
		else setTitle("jRM Gamemaster: N/A");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(true);
		LayoutManager layout = new BorderLayout();
		setLayout(layout);
		background = new JDesktopPane();
		createMenu();
		add(background, BorderLayout.CENTER);
		background.setVisible(true);
		
		JInternalFrame serverStatus = new ServerStatusFrame();
		background.add(serverStatus);
		serverStatus.setVisible(true);
//		JInternalFrame chatFrame = new GameChatFrame();
//		background.add(chatFrame);
//		chatFrame.setVisible(true);
		gmChat = new GMChatFrame();
		gmChat.setServer(this.server);
		background.add(gmChat);
		gmChat.setVisible(true);
		if (gm != null) gm.setChatWindow(gmChat.chatBox);
		
		JPanel statusBar = new GMStatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		pack();
	}

	/**
	 * 
	 * @author Aun Johnsen
	 * 
	 * When closing window, we want to make sure we leave the server.
	 * Gamemaster and Game objects should be removed properly from server
	 * even when unclean exit, but we do not need to put extra work load
	 * on the server.
	 */
	class WindowCloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			GamemasterApp.savePrefs();
			System.out.println("[GM] Trying to close main window!");
			if (GamemasterApp.myGameObject == null) {
				// no game object, skipping
			}
			else {
				try {
					String name = GamemasterApp.myGameObject.getName();
					RMServer server = GamemasterApp.getServer();
					if  (server == null) {
						System.out.println("[GM] No server connected, clean exit!");
						System.exit(0);
					}
					server.signoutGame(name);
					System.out.println("[GM] Terminated game");
				} catch (RemoteException e) {
					System.out.println("[GM] ERROR: Game object lost or connection problems!");
					e.printStackTrace();
				}
			}
			try {
				if (gm == null) {
					System.out.println("[GM] No GM object registered, leaving.");
					System.exit(0);
				}
				String name = gm.getName();
				RMServer server = GamemasterApp.getServer();
				if (server == null) {
					System.out.println("[GM] No server connected, clean exit");
					System.exit(0);
				}
				server.signoutGM(name);
				System.out.println("[GM] Left server");
			} catch (RemoteException e) {
				System.out.println("[GM] ERROR: Lost connection to server!");
				e.printStackTrace();
			}
			System.out.println("[GM] Good night.");
			setVisible(false);
			System.exit(0);
		}
	}
	
	public void createMenu() {
		JMenuItem menuItem;
		ActionListener menuListener = new MenuActionListener();
		MenuListener menuListener2 = new MenuGameListener();
		JMenuBar mbar = new JMenuBar();
		/* Create drop down menus from left to right */
		/* File */
		JMenu menu = new JMenu("File");
		menu.setMnemonic('f');
		mbar.add(menu);
		menuFileNewGame.setMnemonic('n');
		menuFileNewGame.addActionListener(menuListener);
		menuFileNewGame.setEnabled(true);
		menu.add(menuFileNewGame);
		menuFileOpenGame.setMnemonic('o');
		menuFileOpenGame.addActionListener(menuListener);
		menuFileOpenGame.setEnabled(true);
		menu.add(menuFileOpenGame);
		menuFileCloseGame.setMnemonic('c');
		menuFileCloseGame.addActionListener(menuListener);
		menuFileCloseGame.setEnabled(false);
		menu.add(menuFileCloseGame);
		menu.addSeparator();
		menuFileConnect.setMnemonic('c');
		menuFileConnect.addActionListener(menuListener);
		menuFileConnect.setEnabled(true);
		menu.add(menuFileConnect);
		menuFileDisconnect.setMnemonic('d');
		menuFileDisconnect.addActionListener(menuListener);
		menuFileDisconnect.setEnabled(false);
		menu.add(menuFileDisconnect);
		menu.addSeparator();
		menuItem = new JMenuItem("Preferences");
		menuItem.setMnemonic('p');
		menuItem.addActionListener(menuListener);
		menuItem.setEnabled(true);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic('x');
		menuItem.addActionListener(menuListener);
		menuItem.setEnabled(true);
		menu.add(menuItem);
		/* Game */
		menuGame.setMnemonic('g');
		menuGame.setEnabled(false);
		menuGame.addMenuListener(menuListener2);
		menuGameStartGame.setMnemonic('s');
		menuGameStartGame.addActionListener(menuListener);
		menuGameStartGame.setEnabled(false);
		menuGame.add(menuGameStartGame);
		menuGameOpenInvite.setMnemonic('o');
		menuGameOpenInvite.addActionListener(menuListener);
		menuGameOpenInvite.setEnabled(false);
		menuGame.add(menuGameOpenInvite);
		menuGameCloseInvite.setMnemonic('c');
		menuGameCloseInvite.addActionListener(menuListener);
		menuGameCloseInvite.setEnabled(false);
		menuGame.add(menuGameCloseInvite);
		menuItem = new JMenuItem("Load Map");
		menuItem.setMnemonic('l');
		menuItem.setEnabled(true);
		menuItem.addActionListener(menuListener);
		menuGame.add(menuItem);
		mbar.add(menuGame);
		
		setJMenuBar(mbar);
	}
	private class MenuGameListener implements MenuListener {
		public void menuCanceled(MenuEvent event) {
		}
		public void menuDeselected(MenuEvent event) {
		}
		public void menuSelected(MenuEvent event) {
			Game g = GamemasterApp.myGameObject;
			if (g.canStartGame() && g.isStarted() == false) {
				menuGameStartGame.setEnabled(true);
			}
			else menuGameStartGame.setEnabled(false);
			if (g.getVacansies() > 0 && !g.isInvite()) {
				menuGameOpenInvite.setEnabled(true);
			}
			else menuGameOpenInvite.setEnabled(false);
			if (g.isInvite() && g.canStartGame()) {
				menuGameCloseInvite.setEnabled(true);
			}
			else menuGameCloseInvite.setEnabled(false);
		}
	}
	private class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent menuEvent) {
			String cmd = menuEvent.getActionCommand();
			RMServer server = GamemasterApp.getServer();
			Game g = GamemasterApp.getGame();
			switch (cmd) {
			case "New Game":
				System.out.println("[GM] Menu: Create new game");
				JDialog n = new NewGameDialog(gm);
				n.setVisible(true);
				break;
			case "Open Game":
				System.out.println("[GM] Menu: Open saved game");
				try {
					o = new OpenGameDialog();
				} catch (ClassNotFoundException | IOException e) {
					System.out.println("[GM] ERROR: Cannot open file");
					javax.swing.JOptionPane.showMessageDialog(null, "Error opening file, file might be corrupt!");
					e.printStackTrace();
				}
				o.setVisible(true);
				break;
			case "Close Game":
				if (GamemasterApp.myGameObject == null) {
					System.out.println("[GM] Menu: Trying to close non-existing game");
					GamemasterApp.myGameObject = null;
					gameMenuStatus();
					break;
				}
				System.out.println("[GM] Menu: Close active game");
				int i = JOptionPane.showOptionDialog(null,
						"Should game be saved before closing?", 
						"Save before closing?", JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (i == JOptionPane.NO_OPTION) { // close without saving
					try {
						GamemasterApp.serverObj.signoutGame(GamemasterApp.myGameObject.getName());
						GamemasterApp.myGameObject = null;
					} catch (RemoteException e) {
						System.out.println("[GM] ERROR: Cannot sign out game from server!");
						e.printStackTrace();
					}
					gameMenuStatus();
				}
				else if (i == JOptionPane.YES_OPTION) { // save game and close
					try {
						g = GamemasterApp.myGameObject;
						String f = g.getName() + ".rmgame";
						System.out.println("[GM] Saving game as " + f);
						FileOutputStream stream = new FileOutputStream(f);
						ObjectOutputStream out = new ObjectOutputStream(stream);
						out.writeObject(g);
						out.close();
						GamemasterApp.serverObj.signoutGame(GamemasterApp.myGameObject.getName());
						GamemasterApp.myGameObject = null;
					} catch (RemoteException e) {
						System.out.println("[GM] ERROR: Cannot sign out game from server!");
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						System.out.println("[GM] ERROR: File not found");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("[GM] ERROR: Something went wrong");
						e.printStackTrace();
					}
					gameMenuStatus();
				}
				else {
					// option cancelled, do nothing
					System.out.println("[GM] Menu: Close game cancelled!");
				}
				gameMenuStatus();
				break;
			case "Connect":
				try {
					GamemasterApp.connectServer();
				} catch (Exception ex) {
					System.out.println("[GM] Something went wrong connecting to server!");
					ex.printStackTrace();
				}
				server = GamemasterApp.getServer();
				if (server != null) {
					menuFileConnect.setEnabled(false);
					menuFileDisconnect.setEnabled(true);
				}
				break;
			case "Disconnect":
				if (server != null) {
					System.out.println("[GM] Menu: Disconnect");
					if (GamemasterApp.myGameObject == null) {
						// no game object, skipping
					}
					else {
						try {
							String name = GamemasterApp.myGameObject.getName();
							server = GamemasterApp.getServer();
							server.signoutGame(name);
							System.out.println("[GM] Terminated game");
						} catch (RemoteException e) {
							System.out.println("[GM] ERROR: Game object lost or connection problems!");
							e.printStackTrace();
						}
					}
					try {
						if (gm == null) {
							System.out.println("[GM] No GM object registered, do nothing.");
							GamemasterApp.serverObj = null;
							break;
						}
						String name = gm.getName();
						server = GamemasterApp.getServer();
						if  (server == null) {
							System.out.println("[GM] No server connected, do nothing");
							break;
						}
						server.signoutGM(name);
						System.out.println("[GM] Left server");
					} catch (RemoteException e) {
						System.out.println("[GM] ERROR: Lost connection to server!");
						e.printStackTrace();
					}
					GamemasterApp.serverObj = null;
					menuFileDisconnect.setEnabled(false);
					menuFileConnect.setEnabled(true);
				}
				break;
			case "Exit":
				System.out.println("[GM] Menu: Exit");
				GamemasterApp.savePrefs();
				System.out.println("[GM] Trying to close main window!");
				if (GamemasterApp.myGameObject == null) {
					// no game object, skipping
				}
				else {
					try {
						String name = GamemasterApp.myGameObject.getName();
						server = GamemasterApp.getServer();
						server.signoutGame(name);
						System.out.println("[GM] Terminated game");
					} catch (RemoteException e) {
						System.out.println("[GM] ERROR: Game object lost or connection problems!");
						e.printStackTrace();
					}
				}
				try {
					if (gm == null) {
						System.out.println("[GM] No GM object registered, leaving.");
						System.exit(0);
					}
					String name = gm.getName();
					server = GamemasterApp.getServer();
					if  (server == null) {
						System.out.println("[GM] No server connected, clean exit!");
						System.exit(0);
					}
					server.signoutGM(name);
					System.out.println("[GM] Left server");
				} catch (RemoteException e) {
					System.out.println("[GM] ERROR: Lost connection to server!");
					e.printStackTrace();
				}
				System.out.println("[GM] Good night.");
				setVisible(false);
				System.exit(0);
			case "Preferences":
				System.out.println("[GM] Opening Preferences");
				JDialog p = new PreferencesDialog();
				p.setVisible(true);
				break;
			case "Start Game":
				System.out.println("[GM] Starting game");
				ServerApp.printMsg("[Server/Game] " +
						g.getName() + " started.");
				break;
			case "Open Invite":
				System.out.println("[GM] Opening game for invites");
				g.openInvite();
				ServerApp.printMsg("[Server/Game] " + g.getName() +
						" accept invites");
				break;
			case "Close Invite":
				System.out.println("[GM] Closing game for invites");
				g.closeInvite();
				ServerApp.printMsg("[Server/Game] " + g.getName() +
						" no longer accept invites");
				break;
			case "Load Map":
				System.out.println("[GM] Open map file dialog");
				try {
					o = new LoadMapDialog();
				} catch (ClassNotFoundException | IOException e) {
					System.out.println("[GM] ERROR: Cannot open file");
					e.printStackTrace();
				}
				o.setVisible(true);
				break;
			default:
				System.out.println("[GM] ERROR: Unknown menu item envoked " +
						"in GamemasterWindow.Menulistener: " + cmd);
				return;
			}
		}
	}
	
	/**
	 * Called to enable and disable the various items in the Game menu
	 */
	public static void gameMenuStatus() {
		System.out.println("[GM] gameMenuStatus called");
		if (GamemasterApp.myGameObject == null) {
			// No game object, we have no game
			menuFileNewGame.setEnabled(true);
			menuFileOpenGame.setEnabled(true);
			menuFileCloseGame.setEnabled(false);
			menuGame.setEnabled(false);
		}
		else {
			// We have a game
			menuFileNewGame.setEnabled(false);
			menuFileOpenGame.setEnabled(false);
			menuFileCloseGame.setEnabled(true);
			menuGame.setEnabled(true);
		}
	}
	
	public synchronized static void addMap(Map m) {
		maps.add(m);
	}
	public synchronized void removeMap(Map m) {
		maps.remove(m);
	}
	public synchronized ArrayList<Map> getMaps() {
		return maps;
	}
}