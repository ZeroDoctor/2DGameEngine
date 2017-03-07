package com.zerulus.util;

import com.zerulus.tiles.TileManager;

//Sort of
public class AABB {

    private Vector2f pos;
    private float w;
    private float h;

    public AABB(Vector2f pos, int w, int h) {
        //places x and y at the center
        this.pos = pos;
        this.w = w;
        this.h = h;
    }

    public void setBox(Vector2f pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;
    }

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
    
    //int xt = ((pos.x + ax) + c % 2 * 2 - 1) / 16;
    //int yt = ((pos.y + ay) + c / 2 * 2 - 1) / 16;
    
    public int xt = 0;
    public int yt = 0;
    
    public boolean collisionTile(float ax, float ay, TileManager tm) {
    	// 32 is the size of player and 16 is the size of the tile
    	// All of this is just for testing
        for(int h = 0; h < (32/16) + 2; h++) {
        	for(int c = 0; c < 4; c++) {
                //int xt = (int) ((pos.x + ax) + c % 16 * 8 + 4) / 16;
                //int yt = (int) ((pos.y + ay) + c % 16 * 8 + 4) / 16;
                xt = 0;
                yt = 0;
                xt = (int) (( (pos.x + (h % 2) * 16) + ax) + (c % 2) * 10 + 3) / 16;
                yt = (int) (( (pos.y + ((int)(h / 2)) * 16) + ay) + ((int)(c / 2)) * 0 + 14) / 16;
                
                //System.out.println("PLAYER: " + xt + "," + yt);
                
                for(int i = 0; i < tm.getSheetCount(); i++) {
                    if(tm.getTileSheet(i).getView() == 0) {
                        if(tm.getTileSheet(i).getBlock(xt, yt)) {
                            //System.out.println("PLAYER: " + xt + "," + yt);
                            return true;
                        }
                    }
                    
                }
                
            }
        }
        
        
        return false;
    }
    
    /*public boolean collisionTile(float ax, float ay, TileManager tm) {
        
        for(int c = 0; c < 9; c++) {
            //int xt = (int) ((pos.x + ax) + c % 16 * 8 + 4) / 16;
            //int yt = (int) ((pos.y + ay) + c % 16 * 8 + 4) / 16;
            xt = 0;
            yt = 0;
            xt = (int) ((pos.x + ax) + (c % 3) * 16 - 1) / 16;
            yt = (int) ((pos.y + ay) + ((int)(c / 3)) * 2 - 4) / 16;
            
            //System.out.println("PLAYER: " + xt + "," + yt);
            
            for(int i = 0; i < tm.getSheetCount(); i++) {
                if(tm.getTileSheet(i).getView() == 0) {
                    if(tm.getTileSheet(i).getBlock(xt, yt)) {
                        System.out.println("PLAYER: " + xt + "," + yt);
                        return true;
                    }
                }
                
            }
            
        }
        
        return false;
    }*/
}
