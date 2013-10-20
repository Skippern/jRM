package org.gimnechiske.jRM.gui;

import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

import org.gimnechiske.jRM.*;
import org.gimnechiske.jRM.lib.RMSystem;

/**
 * 
 * @author Aun Johnsen
 * 
 * This is a server status frame, that should auto-update information
 * about the connected server.
 */
public class GMChatFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private RMServer server = GamemasterApp.serverObj;
	public Gamemaster gmObject = GamemasterApp.myGamemasterObject;
	private static int cols = 80;
	public GMChatPanel chatBox = new GMChatPanel();
	private static JTextField inputChat = new JTextField(cols);
	public JButton send = new JButton("Send");
	
	public GMChatFrame() throws RemoteException {
		setMaximizable(true);
		setResizable(true);
		setClosable(false);
		setIconifiable(true);
		if (server != null) setTitle("Chat: " + server.getName());
		else setTitle("Chat: <NULL>");
		setVisible(true);
		setLayout(new BorderLayout());
		if (gmObject != null) gmObject.setChatWindow(chatBox);
		add(chatBox, BorderLayout.CENTER);
		add(new inputPane(), BorderLayout.SOUTH);
		pack();
	}
	
	public void setGM(Gamemaster gm) {
		gmObject = gm;
		gmObject.setChatWindow(chatBox);
	}
	public void setServer(RMServer server) {
		this.server = server;
	}
	
	private class inputPane extends JPanel {
		private static final long serialVersionUID = 1L;

		private inputPane() {
			ActionListener l = new chatListener();
			String s;
			if (gmObject != null) s = "<" + gmObject.getName() + ">";
			else s = "<NULL>";
			add(new JLabel(s));
			inputChat.addActionListener(l);
			add(inputChat);
			send.addActionListener(l);
			if (server != null) send.setEnabled(true);
			else send.setEnabled(false);
			add(send);
		}
		
	}

	public class chatListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("[GM] Chat: text entered");
			String m = inputChat.getText();
			String gm = gmObject.getName();
			if (gm == "" || gm == null) {
				chatBox.errorMessage("No Gamemaster name!!!!");
			}
			try {
				System.out.println("[GM] Chat: Sending text to server");
				if (server == null) server = GamemasterApp.getServer();
				server.broadcast(RMSystem.MESSAGE_GAMEMASTER, gm, m);
				chatBox.errorMessage(" <Debugger> (" + gm + ") sendt a message: " + m);
				System.out.println(now()+" <"+gm+"> "+m);
			} catch (RemoteException e) {
				System.out.println("[GM] Chat: ERROR RemoteException");
				chatBox.errorMessage("Could not send text! (RemoteException)");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("[GM] Chat: ERROR NullPointerException");
				chatBox.errorMessage("Could not send text! (NullPointerException)");
				e.printStackTrace();
			}
			inputChat.setText("");
		}
	}

	public synchronized void sender(String m) throws RemoteException {
		String gm = gmObject.getName();
		server.broadcast(RMSystem.MESSAGE_GAMEMASTER, gm, m);
	}
	public synchronized static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("HH:mm:ss");
		return x.format(now);
	}

}
