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
	public EntityPlayer() {
		super();
		x = 0;
		y = 0;
	}
	
	
	@Getter @Setter private short mana;
	@Getter @Setter private short mmana;
	@Getter @Setter protected int x ;
	@Getter @Setter protected int y ;
	public int yprev ;
	public int xprev ;
	public char v = "@".charAt(0);
	public ArrayList<String> turns = new ArrayList<String>();
	
	public void controls(){
		
		CharKey dir = Main.console.inkey();
		if(TickHandler.turnactive){
		switch(dir.code){
		case CharKey.w:
			if(turns.size() !=4){
				turns.add("w");
				Main.console.print(x, y, " ");
				y--;
			}
			break;
		case CharKey.s:
			if(turns.size() !=4){
				turns.add("s");
				Main.console.print(x, y, " ");
				y++;
				}
			break;
		case CharKey.a:
			if(turns.size() !=4){
				turns.add("a");
				Main.console.print(x, y, " ");
				x--;
				}
			break;
		case CharKey.d:
			if(turns.size() != 4){
				turns.add("d");
				Main.console.print(x, y, " ");
				x++;
				}
			break;
		case CharKey.f:
			System.out.println("Current turns list: " + turns.toString());
			break;
		case CharKey.SPACE:
			TickHandler.turnactive = false;
			break;
		}
		}
		
	}
	public void setplayerloc(){
		yprev = y;
		xprev = x;
		
	}
	
}
