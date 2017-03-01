package com.zerulus.tiles;

import java.util.ArrayList;
import java.awt.Graphics2D;

import com.zerulus.util.Vector2f;

public class TileManager {

	private TileSheet[] ts;
	private int sheetCount = 0;

	private final int OBJ = 0;
	private final int FORE = 1;
	private final int BACK = 2;

	public TileManager() {
		ts = new TileSheet[6];
	}

	public void addBlock(int id, int x, int y, int tileSheet) {
		if(tileSheet > sheetCount) {
			System.out.println("That tile sheet does not exist");
		} else {
			ts[tileSheet].addBlock(id, x, y);
		}
	}

	public void addTileSheet(TileSheet ts) {
		if(sheetCount <= 6) {
			this.ts[sheetCount++] = ts;
			this.ts[sheetCount - 1].setView(BACK);
		}
		else
			System.out.println("You have exceed the max amount of tile sheets");
	}

	public void setView(int view, int tileSheet) {
		if(tileSheet > sheetCount) {
			System.out.println("That tile sheet does not exist");
		}
		else if (view > 3) {
			System.out.println("No such layer");
		} else {
			ts[tileSheet].setView(view);
		}
	}

	public void update() {

	}

	public void renderObj(Graphics2D g) {
		for(int i = 0; i < sheetCount; i++) {
			if(ts[i].getView() == OBJ)
				ts[i].render(g);
		}
	}

	public void renderFore(Graphics2D g) {
		for(int i = 0; i < sheetCount; i++) {
			if(ts[i].getView() == FORE)
				ts[i].render(g);
		}
	}

	public void renderBack(Graphics2D g) {
		for(int i = 0; i < sheetCount; i++) {
			if(ts[i].getView() == BACK)
				ts[i].render(g);
		}
	}

}
