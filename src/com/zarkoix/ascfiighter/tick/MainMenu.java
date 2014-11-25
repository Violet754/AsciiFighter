package com.zarkoix.ascfiighter.tick;

import net.slashie.libjcsi.ConsoleSystemInterface;

import com.zarkoix.ascfiighter.Main;

public class MainMenu extends Thread{
	public void run(){
		int selection = 0;
		if(TickHandler.MainMenurun){
			Main.console.print(3, 3, "AsciiFight");
			Main.console.print(3, 4, "Made By Zarkoix and Coldrock7");
			Main.console.print(3,6,  "StartGame!",ConsoleSystemInterface.LIGHT_GRAY);
			
			while(TickHandler.MainMenurun){
				switch(selection){
				case 0:
					Main.console.print(3,6,  "StartGame!",ConsoleSystemInterface.GREEN);
					
					break;
				case 1:
					break;
				}
			}
		}
	}
}
