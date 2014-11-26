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
	//called by main class to init testing of ticks
	public static void initTicks(int initlevel){
		switch(initlevel){
		case 1:
			lvtkrun = true;
			lvtk.start();
			break;
		case 0:
			MainMenurun = true;
			MainMenuTick.start();
			break;
		}
		
		
	}
	//Called at end of a turn in LevelTick
	public static void EndTurn(){
		LevelTick.LocationStore = false;
		inq = Main.player1.turns.size() - 1;
		Main.console.print(EntityPlayer.x, EntityPlayer.y, " ");
		Main.player1.x = Main.player1.xprev;
		Main.player1.y = Main.player1.yprev;
		while(Main.player1.turns.isEmpty() == false){
			String direction = Main.player1.turns.get(inq);
			switch(direction){
				case "w":
					Main.player1.y = Main.player1.y - (short)1;
					Main.player1.turns.remove(inq);
					inq--;
					break;
				case "s":
					Main.player1.y = EntityPlayer.y + (short)1;
					Main.player1.turns.remove(inq);
					inq--;
					break;
				case "a":
					Main.player1.x = EntityPlayer.x - (short)1;
					Main.player1.turns.remove(inq);
					inq--;
					break;
				case "d":
					Main.player1.x = EntityPlayer.x + (short)1;
					Main.player1.turns.remove(inq);
					inq--;
					break;
			
			}
		}
		Main.player1.turns.clear();
		
	}
	
	//Called every tick of a turn in LevelTick
	public static void Turn() {
		
		Main.console.print(EntityPlayer.x, EntityPlayer.y, player1.getVr(),ConsoleSystemInterface.WHITE);
		Main.console.refresh();
		EntityPlayer.controls();
	}
	
	
	

}
