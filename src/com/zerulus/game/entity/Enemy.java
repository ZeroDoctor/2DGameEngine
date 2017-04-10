package com.zerulus.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zerulus.game.util.AABB;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.Vector2f;

public class Enemy extends Entity{

    private AABB circleBounds;
    private int radius = 128;

    public Enemy(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);
        circleBounds = new AABB(new Vector2f(pos.x, pos.y), radius, this);
        attacking = true;
        maxSpeed = 1;

    }


    public void hit() {
    	System.out.println("ENEMY: I've been hit!");
    }

    public void chase(Player p) {
		/*if(p.getPos().y > pos.y) {
            up = false;
			down = true;
        } else { 
            down = false;
			up = true;
        }
        if(p.getPos().x > pos.x) {
			right = true;
            left = false;
        } else {
			left = true;
            right = false;
        }*/
		
		double ax = p.getPos().x - pos.x;
		double ay = p.getPos().y - pos.y;
		double rad = Math.atan2(ay, ax);
		System.out.println(rad);
		
    }

    public void update(Player p) {
    	super.update();

        if(circleBounds.colCircleBox(p.getBounds())) {
            chase(p);
			
			circleBounds.getPos().x += dx;
            hitBounds.getPos().x += dx;
            pos.x += dx;
			
			circleBounds.getPos().y += dy;
            hitBounds.getPos().y += dy;
            pos.y += dy;
        } else {
            right = false;
            left = false;
            down = false;
            up = false;
        }

    	if(attacking) {
            if(hitBounds.collides(p.getBounds())) {
                p.hit();
            }
    	}
    }

    public void render(Graphics2D g) {

    	g.setColor(Color.green);
    	g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()),
                    (int) bounds.getWidth(), (int) bounds.getHeight());

    	if(attacking) {
            g.setColor(Color.red);
            g.drawRect((int) (hitBounds.getPos().getWorldVar().x + hitBounds.getXOffset()), (int) (hitBounds.getPos().getWorldVar().y + hitBounds.getYOffset()),
                        (int) hitBounds.getWidth(), (int) hitBounds.getHeight());
    	}
        g.setColor(Color.green);
        g.drawOval((int) circleBounds.getPos().getWorldVar().x, (int) circleBounds.getPos().getWorldVar().y, radius, radius);

    	g.drawImage(ani.getImage(), (int) pos.getWorldVar().x, (int) pos.getWorldVar().y, size, size, null);
    }

}
