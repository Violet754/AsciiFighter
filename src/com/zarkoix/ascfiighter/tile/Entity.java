package com.zarkoix.ascfiighter.tile;

import lombok.Getter;
import lombok.Setter;

public class Entity extends Tile {
	public Entity(char v, int m, boolean g, short h, short t, short mh) {
		super(v, m, g);
		hp = h;
		maxHp = mh;
		type = t;
	}
	public Entity(){
		super();
	}
	
	@Getter @Setter private short hp;
	@Getter @Setter private short type;
	@Getter @Setter private short maxHp;
	
}
