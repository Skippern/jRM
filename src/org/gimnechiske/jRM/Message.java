package org.gimnechiske.jRM;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sender;
	private String message;
	private int mType;
	private Date now;

	public Message(int mType, String sender, String message) {
		this.sender = sender;
		this.message = message;
		this.mType = mType;
		now = new Date();
		
	}
	public Date getTime() {
		return now;
	}
	public String getSender() {
		return sender;
	}
	public String getMessage() {
		return message;
	}
	public int getMessageType() {
		return mType;
	}
	public String toString() {
		DateFormat x = new SimpleDateFormat("HH:mm:ss ");
		return x.format(now) + "<" + sender + "> " + message;
	}

}
