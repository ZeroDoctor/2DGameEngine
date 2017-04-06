package com.zerulus.game.tiles;

import com.zerulus.game.util.Vector2f;
import java.awt.Graphics2D;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

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

	public HashMap<String, Block> objBlocks;

	// Note: This could be static, so the AABB class can use it
	public static int minBlockSize = Integer.MAX_VALUE;

	public TileManager() {
		ts = new TileMap[6];
		objBlocks = new HashMap<String, Block>();
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
		findMinBlockSize();
	}

	private void findMinBlockSize() {
		System.out.println("min size Before: " + minBlockSize);
		if(sheetCount == 1) {
			minBlockSize = ts[sheetCount - 1].getSize();
		} else {
			for(int i = 0; i <= sheetCount - 2; i++) {
				minBlockSize = Math.min(ts[i].getSize(), ts[i + 1].getSize());
			}
		}
		System.out.println("min size After: " + minBlockSize);
	}

	public void addTileMap(TileMap ts) {
		if(sheetCount <= 6) {
		    this.ts[sheetCount++] = ts;
		    this.ts[sheetCount - 1].setView(BACK);
			this.ts[sheetCount - 1].setTileManager(this);
			findMinBlockSize();
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
	    } else {
			System.out.println("Changing view : " + tileSheet + " at " + tileSheet);
			if(ts[tileSheet].getView() == 0 && view != 0) {
				removingHashMap(ts[tileSheet].getBlocks());
			}

	        ts[tileSheet].setView(view);

			if(view == 0) {
				objBlocks.putAll(ts[tileSheet].getBlocks());
			}
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
				System.out.println("Changing view : " + tileSheet + " at " + i);
				if(ts[i].getView() == 0 && view != 0) {
					removingHashMap(ts[i].getBlocks());
				}
				ts[i].setView(view);

				if(view == 0) {
					objBlocks.putAll(ts[i].getBlocks());
				}
			}
		}
	}

	private void removingHashMap(HashMap<String, Block> blocks) {
		Set<String> set = blocks.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			objBlocks.remove(it.next());
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
