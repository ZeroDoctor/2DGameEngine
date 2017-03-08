package com.zerulus.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.graphics.Animation;
import com.zerulus.graphics.Sprite;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.util.Vector2f;

public class Player extends Entity {

    private Animation ani;

    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int DOWN = 2;
    private final int UP = 3;
    private int currentAnimation;

    public Player(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);

        ani = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }
    
    public Vector2f getPos() { return pos; }

    private void setAnimation(int i, BufferedImage[] b, int d) {
        currentAnimation = i;
        ani.setFrames(b);
        ani.setDelay(d);
    }

    public void anim() {
        if(up) {
            if(currentAnimation != UP || ani.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 10);
            }
        }
        else if(down) {
            if(currentAnimation != DOWN || ani.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 10);
            }
        }
        else if(left) {
            if(currentAnimation != LEFT || ani.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 10);
            }
        }
        else if(right) {
            if(currentAnimation != RIGHT || ani.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    public void update() {
        anim();
        super.update();
        ani.update();
    }

    public void render(Graphics2D g) {
    	
    	
        g.setColor(Color.blue);
        g.drawRect((int) pos.x, (int) pos.y, size / 2, size / 2);
        g.drawRect((int) pos.x + size / 2, (int) pos.y, size / 2, size / 2);
        g.drawRect((int) pos.x, (int) pos.y + size / 2, size / 2, size / 2);
        g.drawRect((int) pos.x + size / 2, (int) pos.y + size / 2, size / 2, size / 2);
        
        g.setColor(Color.green);
        g.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        
        g.drawImage(ani.getImage(), (int) pos.x, (int) pos.y, size, size, null);
    }

    public void input(InputHandler keys, MouseHandler mouse) {
    	// For test purposes
    	if(keys.event.clicked) {
    		bounds.setXOffset(3);
    		bounds.setYOffset(14);
    		bounds.setWidth(25);
    		bounds.setHeight(16);
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
    }
}
