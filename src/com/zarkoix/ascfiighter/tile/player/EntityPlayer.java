package com.zarkoix.ascfiighter.tile.player;

import java.util.ArrayList;

import net.slashie.libjcsi.CharKey;
import lombok.Getter;
import lombok.Setter;

import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tick.TickHandler;
import com.zarkoix.ascfiighter.tile.Entity;
import com.zarkoix.ascfiighter.tile.player.EntityPlayer;

public class EntityPlayer extends Entity {

	public EntityPlayer(char v, int m, boolean g, short h, short t, short mh,short man,short mman,int xloc , int yloc) {
		super(v, m, g, h, t, mh);
		man = mana;
		mman = mmana;
		xloc = x;
		yloc = y;
	}
	
	@Getter @Setter private short mana;
	@Getter @Setter private short mmana;
	@Getter @Setter public static int x = 10;
	@Getter @Setter public static int y = 10;
	public static int yprev ;
	public static int xprev ;
	public static char v = "@".charAt(0);
	public static ArrayList<String> turns = new ArrayList<String>();
	
	public static void controls(int up,int down,int left,int right){
		
		CharKey dir = Main.console.inkey();
		if(dir.code == up&& (y - 1 >= 0)){
			if(turns.size() !=4){
			turns.add("w");
			Main.console.print(x, y, " ");
			y--;
			}
		}
		if(dir.code == down&& (y+1 < 25)){
			if(turns.size() !=4){
			turns.add("s");
			Main.console.print(x, y, " ");
			y++;
			}
		}
		if(dir.code == left&& (x-1 >= 0)){
			if(turns.size() !=4){
			turns.add("a");
			Main.console.print(x, y, " ");
			x--;
			}
		}
		if(dir.code == right && (x+1 < 80)){
			if(turns.size() != 4){
			turns.add("d");
			Main.console.print(x, y, " ");
			x++;
			}
		}
		if(dir.code == CharKey.f){
			System.out.println("Current turns list: " + turns.toString());
		}
		if(dir.code == CharKey.SPACE){
			
			turns = new ArrayList<String>();
			TickHandler.turnactive = false;
		}
		
	}
	public static void setplayerloc(){
		yprev = y;
		xprev = x;
		
	}
	
}
