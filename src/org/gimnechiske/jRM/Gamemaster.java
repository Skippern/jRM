package org.gimnechiske.jRM;

import java.io.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

//import javax.swing.*;

import org.gimnechiske.jRM.gui.*;
/**
 * 
 * @author Aun Johnsen
 *
 * The Gamemaster object to communicate between the Gamemaster app
 * and the server
 */
public class Gamemaster implements Serializable, Remote, RemoteRef, 
		ServerRef {
	private static final long serialVersionUID = 1L;
	private String gmName;
	public GMChatPanel gmChatter;
	public ArrayList<Message> messageQueue = new ArrayList<>();
	
	public Gamemaster() {
		initialize();
	}
	
	public synchronized void setChatWindow(GMChatPanel chat) {
		gmChatter = chat;
		System.out.println("[GM] Chat Panel set");
		initialize();
	}
	public GMChatPanel getChatWindow() {
		return gmChatter;
	}
	
	public synchronized void setName(String name) {
		gmName = name;
	}
	public synchronized String getName() {
		return gmName;
	}
	
	public synchronized void doTick() {
		System.out.println("[GM] Tick!");
	}
		
	private void initialize() {
		System.out.println("[GM] Gamemaster object initialized");
	}

	public void readExternal(ObjectInput arg0) throws IOException,
			ClassNotFoundException {
		/**
		 * We must distinguish whether we are on the server or the client
		 */
		System.out.println("[GM] readExternal(ObjectInput arg0)");
		String f = arg0.getClass().getName();
		System.out.println("[GM] readExternal("+f+")");
		/** How does this work? */
		gmName = (String) arg0.readObject();
		gmChatter = (GMChatPanel) arg0.readObject();
		if (gmChatter == null) System.out.println("[GM] Chatter is NULL");
		else System.out.println("[GM] Chatter is valid: " + gmChatter.isValid());
	}

	public void writeExternal(ObjectOutput arg0) throws IOException {
		/**
		 * We must distinguish whether we are on the server or the client
		 */
		System.out.println("[GM] writeExternal(ObjectOutput arg0)");
		String f = arg0.getClass().getName();
		System.out.println("[GM] readExternal("+f+")");
		/** How does this work? */
		arg0.writeObject(gmName);
		arg0.writeObject(gmChatter);
		if (gmChatter == null) System.out.println("[GM] Chatter is NULL");
		else System.out.println("[GM] Chatter sent: " + gmChatter.isValid());
	}

	@Override
	@Deprecated
	public void done(RemoteCall arg0) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[GM] done(RemoteCall arg0) <deprecated>");
	}

	@Override
	public String getRefClass(ObjectOutput arg0) {
		// TODO Auto-generated method stub
		System.out.println("[GM] getRefClass(ObjectOutput arg0)");
		return null;
	}

	@Override
	@Deprecated
	public void invoke(RemoteCall arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[GM] invoke(RemoteCall arg0) <deprecated>");
	}

	@Override
	public Object invoke(Remote arg0, Method arg1, Object[] arg2, long arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[GM] invoke(Remote arg0, Method arg1, Object[] args, long arg3)");
		return null;
	}

	@Override
	@Deprecated
	public RemoteCall newCall(RemoteObject arg0, Operation[] arg1, int arg2,
			long arg3) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[GM] newCall(RemoteObject arg0, Operation[] arg1, int arg2, long arg3) <deprecated>");
		return null;
	}

	@Override
	public boolean remoteEquals(RemoteRef arg0) {
		// TODO Auto-generated method stub
		System.out.println("[GM] remoteEquals(RemoteRef arg0)");
		return false;
	}

	@Override
	public int remoteHashCode() {
		// TODO Auto-generated method stub
		System.out.println("[GM] remoteHashCode()");
		return 0;
	}

	@Override
	public String remoteToString() {
		// TODO Auto-generated method stub
		System.out.println("[GM] remoteToString()");
		return null;
	}

	@Override
	public RemoteStub exportObject(Remote arg0, Object arg1)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[GM] exportObject(Remote arg0, Object arg1)");
		return null;
	}

	@Override
	public String getClientHost() throws ServerNotActiveException {
		// TODO Auto-generated method stub
		System.out.println("[GM] getClientHost()");
		return null;
	}
	public synchronized void addMessage(Message m) {
		messageQueue.add(m);
	}
	public synchronized ArrayList<Message> getMessages() {
		return messageQueue;
	}
	public synchronized int getQueueLength() {
		return messageQueue.size();
	}
	public synchronized ArrayList<Message> flushMessages() {
		ArrayList<Message> tmp = messageQueue;
		messageQueue.clear();
		return tmp;
	}
	public synchronized void addMessages(ArrayList<Message> mess) {
		/**
		 * The code should check if messages already exists, and add
		 * them to the array list without getting duplicate entries
		 * or overwriting the entire list
		 */
	}
}
