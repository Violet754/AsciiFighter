package com.zarkoix.ascfiighter.tick;

import net.slashie.libjcsi.ConsoleSystemInterface;
import com.zarkoix.ascfiighter.Main;

public class TickHandler {
	//replay array list
	private static LevelTick lvtk = new LevelTick();
	private static MainMenu MainMenuTick = new MainMenu();
	//is LevelTick is running?
	public static boolean lvtkrun = false;
	//is MainMenuRunning?
	public static boolean MainMenurun = false;
	//is a Turn Active?
	public static boolean turnactive = true;
	//what char to start at in CharArray in getPlayers()[0]
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
		inq = Main.getPlayers()[0].turns.size() - 1;
		Main.console.print(Main.getPlayers()[0].getX(), Main.getPlayers()[0].getY(), " ");
		Main.getPlayers()[0].setX(Main.getPlayers()[0].xprev);
		Main.getPlayers()[0].setY(Main.getPlayers()[0].yprev);
		while(Main.getPlayers()[0].turns.isEmpty() == false){
			String direction = Main.getPlayers()[0].turns.get(inq);
			switch(direction){
				case "w":
					Main.getPlayers()[0].setY(Main.getPlayers()[0].getY() - 1);
					Main.getPlayers()[0].turns.remove(inq);
					inq--;
					break;
				case "s":
					Main.getPlayers()[0].setY(Main.getPlayers()[0].getY() + 1);
					Main.getPlayers()[0].turns.remove(inq);
					inq--;
					break;
				case "a":
					Main.getPlayers()[0].setX(Main.getPlayers()[0].getX() - 1);
					Main.getPlayers()[0].turns.remove(inq);
					inq--;
					break;
				case "d":
					Main.getPlayers()[0].setX(Main.getPlayers()[0].getX() + 1);
					Main.getPlayers()[0].turns.remove(inq);
					inq--;
					break;
				default: break;
			
			}
		}
		Main.getPlayers()[0].turns.clear();
		
	}
	
	//Called every tick of a turn in LevelTick
	public static void Turn() {	
		Main.console.print(Main.getPlayers()[0].getX(), Main.getPlayers()[0].getY(), Main.getPlayers()[0].getVr(), ConsoleSystemInterface.WHITE);
		Main.console.refresh();
		Main.getPlayers()[0].controls();
	}
	
	
	

}
