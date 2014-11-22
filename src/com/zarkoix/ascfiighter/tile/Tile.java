package com.zarkoix.ascfiighter.tile;

import lombok.Getter;
import lombok.Setter;

public class Tile {
	public Tile(char v, int m, boolean g){
		vr = v;
		meta = m;
		grav = g;
	}
	public Tile(char v){
		vr = v;
	}
	private char vr; //visual repersentation
	@Getter @Setter private int meta; //meta data
	@Getter @Setter private boolean grav; //gravity?
	
	public char getVr(){
		return vr;
	}
	
	public void setVr(char v){
		vr = v;
	}
}
