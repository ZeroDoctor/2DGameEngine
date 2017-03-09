package com.zerulus.tiles;

import java.awt.Graphics2D;
import java.util.HashMap;

import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;

public class TileMap {

    private Sprite sprite;
    private HashMap<String, Block> blocks;
    private int view = 0;
    private int size = 0;

    public TileMap(String file, int width, int height) {
        sprite = new Sprite(file, width, height);
        blocks = new HashMap<String, Block>();
        size = Math.max(width, height);
    }
    
    public void setView(int view) { this.view = view; }
    public int getView() { return view; }
    
    public int getSize() { return size; }

    public Sprite getTileSprite() { return sprite; }

    public void addBlock(int id, int x, int y) {
        blocks.put(Integer.toString(x / size) + "," + Integer.toString(y / size), new Block(id, new Vector2f(x, y), this));
    }
    
    public boolean removeBlock(int x, int y) {
    	if(blocks.containsKey(Integer.toString(x / size) + "," + Integer.toString(y / size))) {
    		blocks.remove(Integer.toString(x / size) + "," + Integer.toString(y / size));
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
