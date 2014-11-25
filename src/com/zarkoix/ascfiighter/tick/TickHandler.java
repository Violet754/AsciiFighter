package com.zarkoix.ascfiighter.tick;

import java.util.ArrayList;

import net.slashie.libjcsi.ConsoleSystemInterface;

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
		switch(initlevel){
		case 0:
			lvtkrun = true;
			lvtk.start();
			break;
		case 1:
			MainMenurun = true;
			MainMenuTick.start();
			break;
		}
		
		
	}
	//Called at end of a turn in LevelTick
	public static void EndTurn(){
		LevelTick.LocationStore = false;
		inq = EntityPlayer.turns.size() - 1;
		Main.console.print(EntityPlayer.x, EntityPlayer.y, " ");
		EntityPlayer.x = EntityPlayer.xprev;
		EntityPlayer.y = EntityPlayer.yprev;
		while(EntityPlayer.turns.isEmpty() == false){
			String direction = EntityPlayer.turns.get(inq);
			switch(direction){
				case "w":
					EntityPlayer.y = EntityPlayer.y - (short)1;
					EntityPlayer.turns.remove(inq);
					inq--;
					break;
				case "s":
					EntityPlayer.y = EntityPlayer.y + (short)1;
					EntityPlayer.turns.remove(inq);
					inq--;
					break;
				case "a":
					EntityPlayer.x = EntityPlayer.x - (short)1;
					EntityPlayer.turns.remove(inq);
					inq--;
					break;
				case "d":
					EntityPlayer.x = EntityPlayer.x + (short)1;
					EntityPlayer.turns.remove(inq);
					inq--;
					break;
			
			}
		}
		EntityPlayer.turns.clear();
		
	}
	
	//Called every tick of a turn in LevelTick
	public static void Turn() {
		
		Main.console.print(EntityPlayer.x, EntityPlayer.y, player1.getVr(),ConsoleSystemInterface.WHITE);
		Main.console.refresh();
		EntityPlayer.controls();
	}
	
	
	

}
