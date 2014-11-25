package com.zarkoix.ascfiighter.tick;

import com.zarkoix.ascfiighter.tick.TickHandler;

public class LevelTick extends Thread{
	//is the player prev location stored for replay?
	public static boolean LocationStore = false;
	public void run(){
		//save player location at the start of level load
		TickHandler.player1.setplayerloc();
		while(TickHandler.lvtkrun){
			//if a turn is currently ending then
			if(TickHandler.turnactive == false){
				TickHandler.EndTurn();
				TickHandler.turnactive = true;
			//if location has not been stored this turn then store location	
			}else if(LocationStore == false){
					TickHandler.player1.setplayerloc();
					LocationStore = true;
				}
				//if turn is currently active then
				TickHandler.Turn();
		}
	}
}

