package com.zarkoix.ascfiighter.tile;

import net.slashie.libjcsi.CSIColor;
import lombok.Getter;
import lombok.Setter;

public class Tile {
	public Tile(char v, CSIColor m, boolean c){
		vr = v;
		Color = m;
		collision = c;
	}
	public Tile(char lineI){
		vr = lineI;
	}
	private char vr; //visual repersentation
	@Getter @Setter protected CSIColor Color; //Color data
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
