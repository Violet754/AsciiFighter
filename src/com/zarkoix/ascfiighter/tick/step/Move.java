package com.zarkoix.ascfiighter.tick.step;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.levelHandler.Directions;
import com.zarkoix.ascfiighter.tile.entity.player.EntityPlayer;

public class Move implements Step {
	public Move(Directions a){
		direction = a;
	};
	
	Directions direction;
	
	@Override
	public boolean run(EntityPlayer player) {
		switch(direction){
		//north
			case NORTH: if(Main.getLev().getTile(player.getX(), player.getY() - 1).isCollision() != true){
				player.setY(player.getY()- 1);
				player.turns.remove(this);
				return true;
			}
		//east
			case EAST: if(Main.getLev().getTile(player.getX() + 1, player.getY()).isCollision() != true){
				player.setY(player.getX()+ 1);
				player.turns.remove(this);
				return true;
			}
		//south
			case SOUTH: if(Main.getLev().getTile(player.getX(), player.getY() + 1).isCollision() != true){
				player.setY(player.getY() + 1);
				player.turns.remove(this);
				return true;
			}
		//west
			case WEST: if(Main.getLev().getTile(player.getX() - 1, player.getY()).isCollision() != true){
				player.setY(player.getY() - 1);
				player.turns.remove(this);
				return true;
			}
		}
	return false;
	}	
	
}
