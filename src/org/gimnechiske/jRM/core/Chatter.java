package org.gimnechiske.jRM.core;

import java.io.*;

public class Chatter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message, gm;
	
	// constructor
	Chatter(String gm, String message) {
		this.message = message;
		this.gm = gm;
	}
	
	public String getMessage() {
		return message;
	}
	public String getGM() {
		return gm;
	}
	public String toString() {
		return "<" + gm +"> " + message;
	}
	

}
