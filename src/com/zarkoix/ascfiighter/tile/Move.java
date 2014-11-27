package com.zarkoix.ascfiighter.tile;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tile.entity.player.EntityPlayer;

public class Move implements Step {
	public Move(int a){
		direction = a;
	};
	
	int direction;
	
	@Override
	public boolean run(EntityPlayer player) {
		switch(direction){
		//north
			case 0: if(Main.getLev().getTile(player.getX(), player.getY() - 1).isCollision() != true){
				player.setY(player.getY()+ 1);
				player.turns.remove(this);
				return true;
			}
		//east
			case 1: if(Main.getLev().getTile(player.getX() + 1, player.getY()).isCollision() != true){
				player.setY(player.getX()+ 1);
				player.turns.remove(this);
				return true;
			}
		//south
			case 2: if(Main.getLev().getTile(player.getX(), player.getY() + 1).isCollision() != true){
				player.setY(player.getY() - 1);
				player.turns.remove(this);
				return true;
			}
		//west
			case 3: if(Main.getLev().getTile(player.getX() - 1, player.getY()).isCollision() != true){
				player.setY(player.getY() - 1);
				player.turns.remove(this);
				return true;
			}
		}
	return false;
	}	
	
}
