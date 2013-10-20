package org.gimnechiske.jRM.gui.map;

import java.util.*;

/**
 * 
 * @author Aun Johnsen
 * 
 * Primitives are the building blocks of a square map, this interface
 * is used to build the foundations of points, lines, areas and relations
 * which shows up on square maps. The values on the tags determine
 * how they show up in the visual presentation of the GM and the
 * players.
 */
public interface Primitive {
	public void addTag(String key, String value);
	public void removeTag(String key);
	public HashMap<String,String> getTags();

}
