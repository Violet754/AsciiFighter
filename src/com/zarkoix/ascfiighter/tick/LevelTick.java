package com.zarkoix.ascfiighter.tick;

import com.zarkoix.ascfiighter.tile.player.EntityPlayer;
import com.zarkoix.ascfiighter.tick.TickHandler;

public class LevelTick extends Thread{
	public static boolean LocationStore = false;
	public void run(){
		TickHandler.player1.setplayerloc();;
		while(TickHandler.lvtkrun){
			if(TickHandler.turnactive == false){
			TickHandler.EndTurn();
			TickHandler.turnactive = true;
			
			}else{
				if(LocationStore == false){
					EntityPlayer.setplayerloc();
					LocationStore = true;
				}
				TickHandler.StartTurn();
			}
		}
	}
}
