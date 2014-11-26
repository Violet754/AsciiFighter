package com.zarkoix.ascfiighter.levelHandler;

import java.util.List;

import net.slashie.libjcsi.ConsoleSystemInterface;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tile.Tile;
import com.zarkoix.ascfiighter.tile.player.EntityPlayer;

public class levelWrite {
	public static void levelDraw(ConsoleSystemInterface t, Level l){
		for(int y = 0; y < 1000; y++){
			for(int x =0; x < 1000; x++){
				
				if(l.getTile(x, y) != null){
				t.print( x, y ,l.getTile(x, y).getVr());
				}
			}
		}
	}
	
	public static Level levelForm(List<String> lines){
		Level ret = new Level();
		int playerNum = 0;
		for(int y = 0; y < lines.size(); y++){
			
			
			
			char[] lineI = lines.get(y).toCharArray();
			
			for(int x = 0; x < lineI.length; x++){
				if(lineI[x] == "@".charAt(0)){
					Main.getPlayers()[playerNum] = new EntityPlayer('@' ,(short)0 ,true, (short)5, (short)0, (short)5, (short)5, (short)5, x, y);
					playerNum++;
				}else{
				ret.setTile(x, y, new Tile(lineI[x]));
				}
				for(int n = lineI.length; n < 80; n++){
					
					ret.setTile(n, y, new Tile(' '));
				}
			}	
		}; 
		return ret;
	}
}
