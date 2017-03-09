package com.zerulus.util;

import com.zerulus.tiles.TileManager;
import com.zerulus.tiles.TileMap;

//Sort of
public class AABB {

    private Vector2f pos;
    private float xOffset = 0;
    private float yOffset = 0;
    private float w;
    private float h;
    private int size;

    public AABB(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;
        
        size = Math.max(w, h);
    }

    public void setBox(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;
        
        size = Math.max(w, h);
    }
    
    public Vector2f getPos() { return pos; }
    
    public float getWidth() { return w; }
    public float getHeight() { return h; }
    public float getXOffset() { return xOffset; }
    public float getYOffset() { return yOffset; }
    
    public void setWidth(float f) {
    	if(f < TileManager.minBlockSize) {
    		System.out.println("width cannot be smaller than the smallest tile width");
    		w = TileManager.minBlockSize;
    	} else {
    		w = f;
    	}	
    	
    }
    public void setHeight(float f) { 
    	if(f < TileManager.minBlockSize) {
    		System.out.println("height cannot be smaller than the smallest tile height");
    		h = TileManager.minBlockSize;
    	} else {
    		h = f;
    	}	
    	
    }
    
    public void addX(float f) { pos.x += f; }
    public void addY(float f) { pos.y += f; }
    public void setX(float f) { pos.x += f; }
    public void setY(float f) { pos.y += f; }
    
    // the offset are for tile to player collision
    public void setXOffset(float f) { xOffset = f; }
    public void setYOffset(float f) { yOffset = f; }

    public boolean collides(AABB bBox) {
        
        float ax = (pos.x + (w / 2));
        float ay = (pos.y + (h / 2));
        float bx = (bBox.pos.x + (w / 2));
        float by = (bBox.pos.y + (h / 2));
        
        if(Math.abs(ax - bx) < (this.w / 2) + (bBox.w / 2)) {
            if(Math.abs(ay - by) < (this.h / 2) + (bBox.h / 2)) {
                return true;
            }
        }
        
        return false;
    }
    
    /* TODO: Improve collision design
     * currently collision is detected by corner collision.
     * So, that means creating boxes that accounts for an entity
     * being larger than the tiles.
     * 
     * For example, entity A = 32px and tiles = 16px
     * therefore, entity A needs four collision boxes that are 16 by 16
     * if entity A = 64px, then
     * 16 collision boxes
     * 
     * Therefore, this method becomes a problem really fast.
     * One solution is using SAT collision detection and storing
     * the tiles in an array list. However, that means you have to 
     * loop through the entire list just to check if one block collided 
     * with an entity. 
     * */
    public boolean collisionTile(float ax, float ay, TileManager tm, TileMap ts) {
    	int boxes = (int) Math.pow((int) (size / TileManager.minBlockSize), 2);
        for(int b = 0; b < boxes; b++) {
        	for(int c = 0; c < 4; c++) {
        		
        		//Still need to figure out offsets
        		// xt: 10 + 3
        		// yt: 0 + 14
        		int xt = (int) (( (pos.x + (b % (boxes / 2)) * TileManager.minBlockSize) + ax) + (c % 2) *
        				(w - TileManager.minBlockSize) + xOffset) / TileManager.minBlockSize;
        		
                int yt = (int) (( (pos.y + ((int)(b / (boxes / 2))) * TileManager.minBlockSize) + ay) + ((int)(c / 2)) *
                		(h - TileManager.minBlockSize) + yOffset) / TileManager.minBlockSize;
                
                if(ts.getBlock(xt, yt)) {
                    return true;
                }    
            }
        }
        
        return false;
    }
}
