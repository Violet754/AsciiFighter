package com.zarkoix.ascfiighter.tile.player;

import lombok.Getter;
import lombok.Setter;

import com.zarkoix.ascfiighter.tile.Entity;

public class EntityPlayer extends Entity {

	public EntityPlayer(char v, int m, boolean g, short h, short t, short mh,short man,short mman) {
		super(v, m, g, h, t, mh);
		man = mana;
		mman = mmana;
	}
	
	@Getter @Setter private short mana;
	@Getter @Setter private short mmana;

}
