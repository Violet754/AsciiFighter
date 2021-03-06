package com.zarkoix.ascfiighter;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import com.zarkoix.ascfiighter.levelHandler.Level;
import com.zarkoix.ascfiighter.tick.TickHandler;
import com.zarkoix.ascfiighter.tile.entity.player.EntityPlayer;

public class Main{
	//Player Init
	@Getter @Setter protected static EntityPlayer[] players = new EntityPlayer[4];
	public static ConsoleSystemInterface console = null;
	@Getter @Setter protected static Level lev;
	
    public static void Mains() throws IOException{
    	console = new WSwingConsoleInterface("Ascii Fight", false);
    }
 
    public static void main(String[] args) throws IOException {
        Mains();
        console.cls();
       //debug to test ticks and player
       TickHandler.initTicks(0);
        
    }
    
 
    public static void sendmsg(String msg){
    	System.out.println(msg);
    }
}
