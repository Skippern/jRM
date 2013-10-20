package org.gimnechiske.jRM.gui.map;

import java.util.*;

import javax.swing.*;

import org.gimnechiske.jRM.lib.*;
/**
 * 
 * @author Aun Johnsen
 * 
 * The default hexagonal map is meant for large scale overview maps, 
 * such as the maps over continents, kingdoms, etc. It should be easy
 * to paint with left-clicking and selecting basic values such as
 * landscape and main features, and to link each hexagon with default
 * or custom submaps. Creating lines along the borders of the hexagon,
 * or lines through the hexagons should also be easy
 * 
 * The scale should reflect the distance through the hexagon, i.e. the
 * length of each side.
 */
public class HexMap implements Map {
	private static final long serialVersionUID = 1L;
	private static final int mapType = Maps.HEXMAP;
	private static double scale;
	private static String name;
	private static ArrayList<HexPoint> points = new ArrayList<>();
	private Icon icon;

	public HexMap() {}
	
	public void setMapName(String name) {
		HexMap.name = name;
	}
	public void setMapScale(double scale) {
		HexMap.scale = scale;
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
	public void addMapPoint(HexPoint p) {
		points.add(p);
	}
	public void removeMapPoint(HexPoint p) {
		points.remove(p);
	}
	public ArrayList<HexPoint> getMapPoints() {
		return points;
	}
	public void setMapType(int i) {
		// Do nothing, MapType forcefully set to Maps.HEXMAP
	}
	public Icon getMapIcon() {
		return icon;
	}
}
