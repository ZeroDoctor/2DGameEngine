package com.zerulus.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zerulus.graphics.Sprite;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.Vector2f;

public class Enemy extends Entity{
	
    public Enemy(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);
    }
    
    
    public void hit() {
    	System.out.println("I've been hit!");
    }

    public void update() {
    	super.update();
    }

    public void render(Graphics2D g) {
    	
    	g.setColor(Color.green);
    	g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
    	
    	g.drawImage(ani.getImage(), (int) pos.x, (int) pos.y, size, size, null);
    }

}
