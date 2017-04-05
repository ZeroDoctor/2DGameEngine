package com.zerulus.game.tiles;

import java.awt.Graphics2D;
import com.zerulus.game.util.Vector2f;

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
    public TileMap getTileMap(int i) { return ts[i]; }
    public int getTileMapSize() { return ts.length; }
    //public int getMinTileSize() { return minBlockSize; }

   //public void setMinTileSize(int i) { minBlockSize = i; }

	public void addBlock(int imageX, int imageY, Vector2f pos, int tileSheet) {
		if(tileSheet > sheetCount) {
	        System.out.println("outside the bounds of tile sheet");
		}
		else if(ts[tileSheet] == null) {
			System.out.println("That tile sheet does not exist");
		}
		else {
	        ts[tileSheet].addBlock(imageX, imageY, pos);
		}
	}

	public void removeBlock(int x, int y, int tileSheet) {
		if(!ts[tileSheet].removeBlock(x, y)) {
			System.out.println("Nothing there");
		}
	}

	public void setTileMapSize(int id, int w, int h) {
		ts[id].setSize(w, h);
		minBlockSize = Math.min(minBlockSize, Math.max(w, h));
	}

	private void findMinBlockSize() {
		for(int i = 0; i < sheetCount; i++) {
			minBlockSize = Math.min(minBlockSize, ts[i].getSize());
		}
	}

	public void addTileMap(TileMap ts) {
		findMinBlockSize();
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
	/* TODO: fix naming bug
		two tileset could have the same name
		so that could ruin the application when setting
		the view to a tileset
	**/
	public void setView(int view, String tileSheet) {

		for(int i = 0; i < sheetCount; i++) {
			if(ts[i].toString().equals(tileSheet)) {
				ts[i].setView(view);
			}
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
