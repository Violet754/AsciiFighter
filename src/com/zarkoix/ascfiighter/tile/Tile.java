package com.zarkoix.ascfiighter.tile;

import lombok.Getter;
import lombok.Setter;

public class Tile {
	public Tile(char v, int m, boolean c){
		vr = v;
		meta = m;
		collision = c;
	}
	public Tile(){}
	public Tile(char lineI){
		vr = lineI;
	}
	private char vr; //visual repersentation
	@Getter @Setter protected int meta; //meta data
	@Getter @Setter protected boolean collision = false; //collision?
	
	public String getVr(){
		String retString = String.valueOf(vr);
		return retString;
	}
	
	public void steppedOn(){}
	public void interact(){}
	
	public void setVr(char v){
		vr = v;
	}
}
