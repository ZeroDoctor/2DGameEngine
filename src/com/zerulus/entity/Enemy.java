package com.zerulus.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zerulus.graphics.Sprite;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.Vector2f;

public class Enemy extends Entity{
	
    public Enemy(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);
        attacking = true;
        
/*        bounds.setXOffset(3);
		bounds.setYOffset(14);
		bounds.setWidth(25);
		bounds.setHeight(16);*/
    }
    
    
    public void hit() {
    	System.out.println("ENEMY: I've been hit!");
    }

    public void update(Player p) {
    	super.update();
    	
    	if(hitBounds.collides(p.bounds)) {
    		p.hit();
    	}
    }

    public void render(Graphics2D g) {
    	
    	g.setColor(Color.green);
    	g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
    	
    	g.setColor(Color.red);
    	g.drawRect((int) hitBounds.getPos().x, (int) hitBounds.getPos().y, (int) hitBounds.getWidth(), (int) hitBounds.getHeight());
    	
    	g.drawImage(ani.getImage(), (int) pos.x, (int) pos.y, size, size, null);
    }

}
