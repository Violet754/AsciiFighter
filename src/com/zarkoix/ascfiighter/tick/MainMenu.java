package com.zarkoix.ascfiighter.tick;

import java.io.IOException;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.levelHandler.Level;
import com.zarkoix.ascfiighter.levelHandler.levelLoad;
import com.zarkoix.ascfiighter.levelHandler.levelWrite;

public class MainMenu extends Thread{
	public void run(){
		int selection = 0;
		if(TickHandler.MainMenurun){
			Main.console.print(3, 3, "AsciiFight");
			Main.console.print(3, 4, "Made By Zarkoix and Coldrock7");
			Main.console.print(3,6,  "StartGame!",Main.console.WHITE);
			
			while(TickHandler.MainMenurun){
				switch(selection){
				case 0:
					Main.console.print(3,6,  "StartGame!",Main.console.GREEN);
					Main.console.print(3, 7, "Exit!",Main.console.WHITE);
					Main.console.refresh();
					if(Main.console.inkey().code == CharKey.SPACE){
						Main.console.cls();
				        Level lev = null ;
						try {
							lev = levelWrite.levelForm(levelLoad.getLevel("LevelMain.txt"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				        levelWrite.levelDraw(Main.console, lev);
						TickHandler.initTicks(1);
						TickHandler.MainMenurun = false;
						
					}
					break;
				case 1:
					Main.console.print(3,6,  "StartGame!",Main.console.WHITE);
					Main.console.print(3, 7, "Exit!",Main.console.GREEN);
					Main.console.refresh();
					if(Main.console.inkey().code == CharKey.SPACE){
						Main.console.cls();
						Main.console = null;
						System.exit(getPriority());
					}
				}
				switch(Main.console.inkey().code){
				case CharKey.w:
					selection = 0;
					break;
				case CharKey.s:
					selection = 1;
					break;
				}
			}
		}
	}
}
