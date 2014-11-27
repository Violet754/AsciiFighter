package com.zarkoix.ascfiighter.tile.entity;

import lombok.Getter;
import net.slashie.libjcsi.CSIColor;

import com.zarkoix.ascfiighter.levelHandler.Directions;
import com.zarkoix.ascfiighter.tile.Tile;

public class Projectile extends Tile {
private char vrVert = '|';
@Getter private Directions direction;
	public Projectile(char vh, char vv, CSIColor m) {
		super(vh, m, true);
		vrVert = vv;
	}
	@Override
	public String getVr(){
		switch (direction){
			case NORTH: 
				return String.valueOf(vrVert);
			case EAST:
				return super.getVr();
			case SOUTH: 
				return String.valueOf(vrVert);
			case WEST: 
				return super.getVr();
		}
		return "x";
	}

}
