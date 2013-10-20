package org.gimnechiske.jRM.gui.map;

import java.util.*;

import javax.swing.*;

import org.gimnechiske.jRM.lib.*;
/**
 * 
 * @author Aun Johnsen
 * 
 * The square map is a detailed map, it is used to create floor plans
 * of keeps, city views, dungeon maps, etc. This is the most detailed
 * and flexible map. Objects are drawn 'freehand' in much the same
 * way as OpenStreetMap. The co-ordinates are X/Y based on where the
 * GM starts to draw. Details on points, lines, areas and relations
 * are tagged, where some standard tags exists to quickly make default
 * items, some tags are more dynamic allowing the GM to attach information
 * to the objects.
 */
public class SquareMap implements Map {
	private static final long serialVersionUID = 1L;
	private String name;
	private static final int mapType = Maps.SQUAREMAP;
	private double scale;
	private ArrayList<Primitive> mapObjs = new ArrayList<>();
	private Icon icon;
	
	public void setMapName(String name) {
		this.name = name;
	}
	public void setMapType(int i) {
		// Do nothing, MapType forcefully set to Maps.SQUAREMAP
	}
	public void setMapScale(double scale) {
		this.scale = scale;
	}
	public String getMapName() {
		return name;
	}
	public int getMapType() {
		return mapType;
	}
	public double getMapScale() {
		return scale;
	}
	
	public void addObject(Primitive p) {
		mapObjs.add(p);
	}
	public void removeObject(Primitive p) {
		mapObjs.remove(p);
	}
	public ArrayList<Primitive> getObjects() {
		return mapObjs;
	}
	public Icon getMapIcon() {
		return icon;
	}

}
