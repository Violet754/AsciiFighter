package com.zarkoix.ascfiighter;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.util.Position;

import com.zarkoix.ascfiighter.levelHandler.Level;
import com.zarkoix.ascfiighter.levelHandler.levelLoad;
import com.zarkoix.ascfiighter.levelHandler.levelWrite;

public class Main extends JFrame{
	public static ConsoleSystemInterface console = null;
	private static final long serialVersionUID = 2060623638149583738L;

	
	
    public static void Mains() throws IOException{
    	console = new WSwingConsoleInterface("Ascii Fight", false);
    }
    public static int consoleHight(){
    	boolean returninf = false;
    	for(int y = 0; y < 100; y++){
    		Position pos = new Position(1, y);
    		returninf = console.isInsideBounds(pos);
    		if(returninf == false){
    			return y - 1;
    			
    		}
    	}
		return 0;
    	
    }
 
    public static void main(String[] args) throws IOException {
        Mains();
        console.cls();
        Level lev = levelWrite.levelForm(levelLoad.getLevel("/Users/coldrock/git/AsciiFighter/lvl.txt"));
       levelWrite.levelDraw(console, lev);
        
    }
    
 
    public void repaint(){
        super.repaint();
        console.refresh();
    }
    public static void sendmsg(String msg){
    	System.out.println(msg);
    }
}
