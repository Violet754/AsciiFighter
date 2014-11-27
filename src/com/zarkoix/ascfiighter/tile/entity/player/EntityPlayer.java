package com.zarkoix.ascfiighter.tile.entity.player;

import java.util.ArrayList;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import lombok.Getter;
import lombok.Setter;

import com.zarkoix.ascfiighter.levelHandler.Directions;
import com.zarkoix.ascfiighter.Main;
import com.zarkoix.ascfiighter.tick.TickHandler;
import com.zarkoix.ascfiighter.tick.step.Move;
import com.zarkoix.ascfiighter.tick.step.Step;
import com.zarkoix.ascfiighter.tile.entity.Entity;
import com.zarkoix.ascfiighter.tile.entity.player.EntityPlayer;

public class EntityPlayer extends Entity {

	public EntityPlayer(char v, CSIColor m, boolean g, short h, short t, short mh,short man,short mman,int xloc , int yloc) {
		super(v, m, g, h, t, mh);
		mana = man;
		mmana = mman;
		x = xloc;
		y = yloc;
	}
	
	
	@Getter @Setter private short mana;
	@Getter @Setter private short mmana;
	@Getter @Setter protected int x ;
	@Getter @Setter protected int y ;
	public int yprev ;
	public int xprev ;
	public char v = "@".charAt(0);
	public ArrayList<Step> turns = new ArrayList<Step>();
	
	public void controls(){
		CharKey dir = Main.console.inkey();
		switch(dir.code){
		case CharKey.w:
			if(turns.size() !=4 && Main.getLev().getTile(x, y - 1).isCollision() != true){
				turns.add(new Move(Directions.NORTH));
				Main.console.print(x, y, " ");
				y--;
				break;
			}
			break;
		case CharKey.s:
			if(turns.size() !=4 && Main.getLev().getTile(x, y + 1).isCollision() != true){
				turns.add(new Move(Directions.SOUTH));
				Main.console.print(x, y, " ");
				y++;
				break;
				}
			break;
		case CharKey.a:
			if(turns.size() !=4 && Main.getLev().getTile(x - 1, y).isCollision() != true){
				turns.add(new Move(Directions.WEST));
				Main.console.print(x, y, " ");
				x--;
				break;
				}
			break;
		case CharKey.d:
			if(turns.size() != 4 && Main.getLev().getTile(x + 1, y).isCollision() != true){
				turns.add(new Move(Directions.EAST));
				Main.console.print(x, y, " ");
				x++;
				break;
				}
			break;
		case CharKey.f:
			System.out.println("Current turns list: " + turns.toString());
			break;
		case CharKey.SPACE:
			TickHandler.turnactive = false;
			break;
		//WIP
		case CharKey.q:
			if(!turns.isEmpty()){
				Step remove = turns.get(turns.size() - 1);
				turns.remove(remove);
				break;
			}
			break;
		}
		}
	public void print(int x,int y){
		Main.console.print(x, y, this.getVr(),ConsoleSystemInterface.WHITE);
	}
	
	public void setplayerloc(){
		yprev = y;
		xprev = x;
		
	}
	
}
