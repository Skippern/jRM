package org.gimnechiske.jRM.gui.map;

import java.io.*;
import java.util.*;

import org.gimnechiske.jRM.lib.*;
/**
 * 
 * @author Aun Johnsen
 *
 * HexPoints are individual hex's in a hexagonal map. It contains
 * information about a particular hex with landscape (background 
 * color), main feature (foreground symbol), tags (can contain 
 * general information such as names, GM related information such 
 * as game hooks and plot clues, and player related information
 * such as what the players have learned about it), and linked
 * maps (such as finer detailed maps)
 */
public class HexPoint implements Serializable {
	private static final long serialVersionUID = 1L;
	private int hexID;
	private int landscape;
	private int feature = Maps.HEX_NONE;
	private HashMap<String, String> tags = new HashMap<>();
	private Map subMap = null;
	
	public HexPoint(int hexID) {
		this.hexID = hexID;
	}
	
	public void setHexId(int i) {
		hexID = i;
	}
	public void setLandscape(int i) {
		landscape = i;
	}
	public void setFeature(int i) {
		feature = i;
	}
	public int getHexId() {
		return hexID;
	}
	public int getLandscape() {
		return landscape;
	}
	public int getFeature() {
		return feature;
	}
	public void setSubMap(Map m) {
		subMap = m;
	}
	public Map getSubMap() {
		return subMap;
	}
	public void addTag(String key, String value) {
		tags.put(key, value);
	}
	public void removeTag(String key) {
		tags.remove(key);
	}
	public String getValue(String key) {
		return tags.get(key);
	}
	public HashMap<String,String> getTags() {
		return tags;
	}
}
