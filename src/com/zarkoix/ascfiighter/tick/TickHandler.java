package com.zarkoix.ascfiighter.tick;

import net.slashie.libjcsi.ConsoleSystemInterface;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tick.step.Move;
import com.zarkoix.ascfiighter.tick.step.Step;

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
			lvtk.run();
			break;
		case 0:
			if(MainMenurun == false && !lvtk.isAlive()){
			MainMenurun = true;
			MainMenuTick.run();
			}else{
				Main.console.cls();
				MainMenurun = true;
				MainMenuTick.run();
				Main.setPlayers(null);
			}
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
			Step direction = Main.getPlayers()[0].turns.get(inq);
			direction.run(Main.getPlayers()[0]);
			inq--;
			if(inq == -1){
				Main.getPlayers()[0].turns.clear();
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
