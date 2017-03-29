package com.zerulus.game.tiles;

import java.awt.Graphics2D;
import java.util.HashMap;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.util.Vector2f;

public class TileMap {

    private Sprite sprite;
    private HashMap<String, Block> blocks;
    private int view = 0;
    private int size = 0;

    public TileMap(String file, int width, int height) {
        sprite = new Sprite(file, width, height);
        blocks = new HashMap<String, Block>();
        size = 16;//Math.max(width, height);
    }

    public void setView(int view) { this.view = view; }
    public int getView() { return view; }

    public int getSize() { return size; }

    public Sprite getTileSprite() { return sprite; }

    public void addBlock(int id, Vector2f pos) {
    	if(blocks.containsKey(Integer.toString((int) pos.x / size) + "," + Integer.toString((int) pos.y / size))) {
            if(blocks.get(Integer.toString((int) pos.x / size) + "," + Integer.toString((int) pos.y / size)).getId() != id) {
                System.out.println("Removing current block!");
                //removeBlock(x, y);
                blocks.put(Integer.toString((int) pos.x / size) + "," + Integer.toString((int) pos.y / size), new Block(id, size, pos.getWorldVar(), this));
            } else {
                System.out.println("Why? Its the same block!");
            }
    	} else {
            if(size > TileManager.minBlockSize) {
                for(int i = 0; i < Math.pow((size / TileManager.minBlockSize), 2); i++) {
                    if(i != 0) id = -1;
                    int xt = ((int) pos.x / TileManager.minBlockSize) + (i % (size / TileManager.minBlockSize) );
                    int yt = ((int) pos.y / TileManager.minBlockSize) + ((int) (i / (size / TileManager.minBlockSize)) );

                    blocks.put(Integer.toString(xt) + "," + Integer.toString(yt),
                                    new Block(id, size, pos.getWorldVar(), this));
                }
    		} else {
                    System.out.println("Key: " + (pos.x / size) + ", " + ((pos.y / size)) + "\nBlock: " + pos + "\nWorldBlock: " + pos.getWorldVar());
                    blocks.put(Integer.toString((int) pos.x / size) + "," + Integer.toString((int) (pos.y / size)),
                                    new Block(id, size, pos, this));
    		}

    	}
    }

    /* TODO: fix removeBlock method
     * If the minBlockSize is 16, the method will only
     * remove one part of 32 by 32 tile (for example).
     *
     * One solution is to have the blocks keep track of
     * the other blocks, so when one of them is remove, all
     * of the sibling blocks would be removed as well.
     * */
    public boolean removeBlock(int x, int y) {
    	if(blocks.containsKey(Integer.toString((x / TileManager.minBlockSize)) + "," + Integer.toString((y / TileManager.minBlockSize)))) {
    		blocks.remove(Integer.toString((x / TileManager.minBlockSize)) + "," + Integer.toString((y / TileManager.minBlockSize)));
    		return true;
    	}

    	return false;
    }

    public boolean getBlock(int x, int y){
        return blocks.containsKey(Integer.toString(x) + "," + Integer.toString(y));
    }

    public void render(Graphics2D g) {
    	// ArrayList would probably be better
    	// however, it is easier to get individual blocks
    	// using a hash map.
        for(Block block: blocks.values()) {
            block.render(g);
        }
    }
}
