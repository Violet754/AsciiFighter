package com.zarkoix.ascfiighter.levelHandler;

import java.util.List;

import net.slashie.libjcsi.ConsoleSystemInterface;

import com.zarkoix.ascfiighter.tile.Tile;

public class levelWrite {
	public static void levelDraw(ConsoleSystemInterface t, Level l){
		for(int y = 0; y < 24; y++){
			for(int x =0; x < 80; x++){
				System.out.println("x: " + x);
				System.out.println("y: " + y);
				System.out.println();
				
				t.print( x, y ,l.getTile(x, y).getVr());
			}
		}
	}
	
	public static Level levelForm(List<String> lines){
		Level ret = new Level();
		for(int y = 0; y < 24; y++){
			
			if(lines.get(y) == null){
				System.out.println("null line @: " + y);
			}
			
			char[] lineI = lines.get(y).toCharArray();
			String lineIString = new String(lineI);
			
			for(int x = 0; x < lineI.length; x++){
				
				ret.setTile(x, y, new Tile(lineI[x]));
				
				for(int n = lineI.length; n < 80; n++){
					System.out.println("sysnthesize tile @: " + x + " " + y);
					ret.setTile(n, y, new Tile(' '));
				}
			}	
		}; 
		return ret;
	}
}
