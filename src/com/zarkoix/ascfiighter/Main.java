package com.zarkoix.ascfiighter;

import java.io.IOException;

import javax.swing.JFrame;

import lombok.Getter;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

import com.zarkoix.ascfiighter.levelHandler.Level;
import com.zarkoix.ascfiighter.levelHandler.levelLoad;
import com.zarkoix.ascfiighter.levelHandler.levelWrite;
import com.zarkoix.ascfiighter.tick.TickHandler;
import com.zarkoix.ascfiighter.tile.player.EntityPlayer;

public class Main extends JFrame{
	//Player Init
	public static EntityPlayer player1 = new EntityPlayer('@' ,(short)0 ,true, (short)5, (short)0, (short)5,(short)5,(short)5,10,10);
	public static ConsoleSystemInterface console = null;
	private static final long serialVersionUID = 2060623638149583738L;
	@Getter private static Level lev;
	
	
    public static void Mains() throws IOException{
    	console = new WSwingConsoleInterface("Ascii Fight", false);
    }
 
    public static void main(String[] args) throws IOException {
        Mains();
        console.cls();
        lev = levelWrite.levelForm(levelLoad.getLevel("LevelMain.txt"));
        levelWrite.levelDraw(console, lev);
       //debug to test ticks and player
       TickHandler.initTicks(0);
        
    }
    
 
    public void repaint(){
        super.repaint();
        console.refresh();
    }
    public static void sendmsg(String msg){
    	System.out.println(msg);
    }
}
