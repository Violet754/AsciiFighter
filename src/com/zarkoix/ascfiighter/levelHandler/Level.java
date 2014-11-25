package com.zarkoix.ascfiighter.levelHandler;

import com.zarkoix.ascfiighter.tile.Tile;

public class Level {
	  private Tile[][] level = new Tile[1000][1000];
	public Tile getTile(int x, int y){
		return level[x][y];
	}
	public void setTile(int x, int y, Tile t){
		level[x][y] = t;
	}
}
