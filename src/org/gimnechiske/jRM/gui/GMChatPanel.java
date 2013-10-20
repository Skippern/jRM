package org.gimnechiske.jRM.gui;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.*;

import javax.swing.*;

import org.gimnechiske.jRM.GamemasterApp;
import org.gimnechiske.jRM.Message;

public class GMChatPanel extends JScrollPane implements Serializable {
	private static final long serialVersionUID = 1L;
	private JTextArea history = new JTextArea();

	public GMChatPanel() {
		super();
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		history.setLineWrap(true);
		history.setEditable(false);
		add(history);
		history.setText("<" + 
				GamemasterApp.getGamemaster().getName() + "> joined the chat");
		repaint();

		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				GamemasterApp.getServerChatMessages();
				ArrayList<Message> mess = GamemasterApp.gmMessageQueue;
				String tmp = "<" + GamemasterApp.getGamemaster().getName() + "> joined the chat";
				for (Message m : mess) {
					tmp += m.toString();
				}
				history.setText(tmp);
			}
		}, 0, 10, TimeUnit.SECONDS);

	}
	
	public synchronized final void errorMessage(String m) {
		String tmp = now() + " <ERROR:> " + m + "\n";
		String chatText = history.getText();
		chatText += tmp;
		history.setText(chatText);
		repaint();
	}
	
	public synchronized static String now() {
		Date now = new Date();
		DateFormat x = new SimpleDateFormat("HH:mm:ss");
		return x.format(now);
	}
}
