package com.zarkoix.ascfiighter.tick;

import java.util.ArrayList;

import net.slashie.libjcsi.CharKey;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tile.player.EntityPlayer;

public class TickHandler {
	//replay array list
	private static ArrayList<String> replay = new ArrayList<String>();
	private static LevelTick lvtk = new LevelTick();
	private static MainMenu MainMenuTick = new MainMenu();
	//is LevelTick is running?
	public static boolean lvtkrun = false;
	//is MainMenuRunning?
	public static boolean MainMenurun = false;
	//is a Turn Active?
	public static boolean turnactive = true;
	//what char to start at in CharArray in Player1
	private static int inq = 3;
	//Player Init
	public static EntityPlayer player1 = new EntityPlayer(EntityPlayer.v,(short)0 ,true, (short)5, (short)0, (short)5,(short)5,(short)5,10,10);
	//called by main class to init testing of ticks
	public static void initTicks(int initlevel){
		if(initlevel == 0){
			lvtkrun = true;
			lvtk.start();
			
		}else if(initlevel == 1){
			MainMenurun = true;
			MainMenuTick.start();
			
		}
		
		
	}
	//Called at end of a turn in LevelTick
	public static void EndTurn(){
		LevelTick.LocationStore = false;
		inq = player1.turns.size() - 1;
		Main.console.print(player1.x, player1.y, " ");
		player1.x = player1.xprev;
		player1.y = player1.yprev;
		while(player1.turns.isEmpty() == false){
			String direction = player1.turns.get(inq);
			switch(direction){
				case "w":
					player1.y = player1.y - (short)1;
					player1.turns.remove(inq);
					inq--;
					break;
				case "s":
					player1.y = player1.y + (short)1;
					player1.turns.remove(inq);
					inq--;
					break;
				case "a":
					player1.x = player1.x - (short)1;
					player1.turns.remove(inq);
					inq--;
					break;
				case "d":
					player1.x = player1.x + (short)1;
					player1.turns.remove(inq);
					inq--;
					break;
			
			}
		}
		player1.turns.clear();
		
	}
	
	private static void playerprint(int x,int y) {
		Main.console.print(x, y, "@",Main.console.WHITE);
		
	}
	//Called every tick of a turn in LevelTick
	public static void Turn() {
		
		Main.console.print(player1.x, player1.y, player1.getVr(),Main.console.WHITE);
		Main.console.refresh();
		player1.controls();
	}
	
	
	

}
