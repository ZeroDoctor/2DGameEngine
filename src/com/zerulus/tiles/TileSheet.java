package com.zerulus.tiles;

import java.awt.Graphics2D;
import java.util.HashMap;

import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;

public class TileSheet {

    private Sprite sprite;
    private HashMap<String, Block> blocks;
    private int view = 0;

    public TileSheet(String file, int width, int height) {
        sprite = new Sprite(file, width, height);
        blocks = new HashMap<String, Block>();
    }
    
    public void setView(int view) { this.view = view; }
    public int getView() { return view; }

    public Sprite getTileSprite() { return sprite; }

    public void addBlock(int id, int x, int y) {
        // the x and y could be the id of the block
        System.out.println(x / 16 + "," + y / 16);
        blocks.put(Integer.toString(x / 16) + "," + Integer.toString(y / 16),new Block(id, new Vector2f(x, y), this));
    }
    
    public boolean getBlock(int x, int y){ 
        //System.out.println("BLOCK: " + Integer.toString(x) + "," + Integer.toString(y));
        return blocks.containsKey(Integer.toString(x) + "," + Integer.toString(y)); 
    }

    public void render(Graphics2D g) {
        for(Block block: blocks.values()) {
            block.render(g);
        }
    }
}
