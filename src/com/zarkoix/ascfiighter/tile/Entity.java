package com.zarkoix.ascfiighter.tile;

import lombok.Getter;
import lombok.Setter;

public class Entity extends Tile {
	public Entity(char v, int m, boolean g, short h, short t) {
		super(v, m, g);
		hp = h;
		type = t;
	}
	@Getter @Setter private short hp;
	@Getter @Setter private short type;
	
}
