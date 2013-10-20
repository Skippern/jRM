package org.gimnechiske.jRM.gui.map;

import java.awt.*;

import javax.swing.*;

import org.gimnechiske.jRM.lib.*;

public class ImgMap implements Map {
	private static final long serialVersionUID = 1L;
	private String name;
	private double scale;
	private static final int mapType = Maps.IMGMAP;
	private Image img;
	private Icon icon;

	public void setMapName(String name) {
		this.name = name;
	}
	public void setMapType(int i) {
		// Do nothing, MapType forcefully set to Maps.IMGMAP
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
	public void setImage(Image img) {
		this.img = img;
	}
	public Image getImage() {
		return img;
	}
	public Icon getMapIcon() {
		return icon;
	}

}
