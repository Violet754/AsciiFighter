package com.zarkoix.ascfiighter.tile;

import com.zarkoix.ascfiighter.tile.player.EntityPlayer;

public class Move implements Step {
	public Move(int a){
		direction = a;
	};
	
	int direction;
	
	@Override
	public boolean play(EntityPlayer player) {
		//TODO MOVEMENT CODE
		return false;
	}

}
