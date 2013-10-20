package org.gimnechiske.jRM.gui.map;

import java.io.Serializable;

import javax.swing.Icon;

/**
 * 
 * @author Aun Johnsen
 *
 * Map object should contain information about scale, geographical features
 * such as terrain, roads, keeps, dungeons etc and place them in a
 * hexagonal or rectangle grid. It should be created in such a way that
 * it is easy for a gamemaster to paint it, and for the player to interpret
 * the information from the map. It should also be easy to transmit the map
 * to players and to place and move objects on them.
 * 
 * @param setMapType(int i); sets the type of map, there are 3 main types
 * Maps.HEXMAP - hexagon map (typical a world map)
 * Maps.SQUAREMAP - square map (typical a floor plan or dungeon)
 * Maps.IMGMAP - imported images (scanned paper maps, etc)
 */
public interface Map extends Serializable {
	public void setMapName(String name);
	public void setMapType(int i);
	public void setMapScale(double scale);
	
	public String getMapName();
	public int getMapType();
	public double getMapScale();
	
	public Icon getMapIcon();
}
