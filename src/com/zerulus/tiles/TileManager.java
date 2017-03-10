package com.zerulus.tiles;

import java.awt.Graphics2D;

public class TileManager {
	
	/* TODO: Maybe we can split the tile sheets
	 * into three separate arrays
	 * 
	 * Or store the tile sheets in a tree
	 * with three branch for background, 
	 * foreground, and object tile sheets.
	 */

	private TileMap[] ts;
	private int sheetCount = 0;

	private final int OBJ = 0;
	private final int FORE = 1;
	private final int BACK = 2;
	
	// Note: This could be static, so the AABB class can use it
	public static int minBlockSize = Integer.MAX_VALUE;

	public TileManager() {
		ts = new TileMap[6];
	}
        
    public int getSheetCount() { return sheetCount; }
    public TileMap getTileMap(int i) {return ts[i]; }
    public int getTileMapSize() { return ts.length; }
    //public int getMinTileSize() { return minBlockSize; }
    
   //public void setMinTileSize(int i) { minBlockSize = i; }
        
	public void addBlock(int id, int x, int y, int tileSheet) {
		if(tileSheet > sheetCount) {
	        System.out.println("That tile sheet does not exist");
		} else {
	        ts[tileSheet].addBlock(id, x, y);
		}
	}
	
	public void removeBlock(int x, int y, int tileSheet) {
		if(!ts[tileSheet].removeBlock(x, y)) {
			System.out.println("Nothing there");
		}
	}

	public void addTileMap(TileMap ts) {
		minBlockSize = 16;//Math.min(minBlockSize, ts.getSize());
		if(sheetCount <= 6) {
		    this.ts[sheetCount++] = ts;
		    this.ts[sheetCount - 1].setView(BACK);
		}
		else
		    System.out.println("You have exceed the max amount of tile sheets");
	}
        
	public void removeTileMap(int index) {
	    if(index <= 6) {
	        for(int i = index + 1; i < sheetCount; i++) {
	            ts[i - 1] = ts[i];
	        }
	        sheetCount--;
	    } else {
	        System.out.println("Sadly, no such tile sheet");
	    }
	
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
