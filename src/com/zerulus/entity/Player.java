package com.zerulus.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.graphics.Sprite;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.util.Vector2f;

public class Player extends Entity {

    
    public Player(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);

        
    }
    
    public Vector2f getPos() { return pos; }
    
    public void hit() {
    	System.out.println("PLAYER: I've been hit!");
    }

    public void update(ArrayList<Enemy> e) {
        super.update();
        
        if(attacking) {
        	
        	for(int i = 0; i < e.size(); i++) {
        		//System.out.println("Hello");
        		if(hitBounds.collides(e.get(i).getBounds()) ) {
        			e.get(i).hit();
        			
        		} 
        	}
        }
        
    }

    public void render(Graphics2D g) {
    	
        g.setColor(Color.blue);
        g.drawRect((int) pos.x, (int) pos.y, size / 2, size / 2);
        g.drawRect((int) pos.x + size / 2, (int) pos.y, size / 2, size / 2);
        g.drawRect((int) pos.x, (int) pos.y + size / 2, size / 2, size / 2);
        g.drawRect((int) pos.x + size / 2, (int) pos.y + size / 2, size / 2, size / 2);
        
        g.setColor(Color.green);
        g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        
        if(attacking) {
        	g.setColor(Color.red);
        	g.drawRect((int) hitBounds.getPos().x, (int) hitBounds.getPos().y, (int) hitBounds.getWidth(), (int) hitBounds.getHeight());
        }
        
        g.drawImage(ani.getImage(), (int) pos.x, (int) pos.y, size, size, null);
    }

    public void input(InputHandler keys, MouseHandler mouse) {
    	// For test purposes
    	if(keys.event.clicked) {
    		bounds.setXOffset(3);
    		bounds.setYOffset(14);
    		bounds.setWidth(25);
    		bounds.setHeight(16);
    		acc = 0.2f;
    	}
    	
    	if(keys.menu.clicked) {
    		System.out.println(pos.x + ", " + pos.y);
    	}
    	
        if(keys.up.down) {
            up = true;
        } else {
            up = false;
        }
        if(keys.down.down) {
            down = true;
        } else {
            down = false;
        }
        if(keys.left.down) {
            left = true;
        } else {
            left = false;
        }
        if(keys.right.down) {
            right = true;
        } else {
            right = false;
        }
        
        if(keys.attack.down) {
        	//System.out.println("Hello");
        	attacking = true;
        } else {
        	attacking = false;
        }
        
    }
}
