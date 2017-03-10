package com.zerulus.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.graphics.Animation;
import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;
import com.zerulus.util.AABB;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.tiles.TileManager;

public abstract class Entity {

    protected Vector2f pos;
    protected Sprite sprite;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attacking;

    protected float dx;
    protected float dy;
    protected int size;

    protected float maxSpeed = 1f;
    protected float acc = 0.1f;
    protected float deacc = 0.1f;

    protected AABB bounds;
    protected AABB hitBounds;
    
    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int DOWN = 2;
    private final int UP = 3;
    private int currentAnimation;
    protected Animation ani;
    
    private TileManager tm;

    public Entity(Sprite sprite, Vector2f orgin, TileManager tm) {
        this.sprite = sprite;
        pos = orgin;
        size = Math.max(sprite.w, sprite.h);
        bounds = new AABB(orgin, size, size);
        hitBounds = new AABB(new Vector2f(orgin.x + (size / 2), orgin.y), size, size);
        this.tm = tm;
        
        // Just in case user has not made a TileMap
        if(tm.getTileMapSize() == 0) {
        	TileManager.minBlockSize = size;
        }
        
        ani = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float i) { maxSpeed = i; }
    public void setAcc(float i) { acc = i; }
    public void setDeacc(float i) { deacc = i; }
    
    public AABB getBounds() { return bounds; }
    
    private void move() {
        if(up) {
            dy -= acc;
            if(dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }
        
        if (down) {
            dy += acc;
            if(dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }
        
        if(left) {
            dx -= acc;
            if(dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }
        
        if(right) {
            dx += acc;
            if(dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }
    }
    
    public Animation getAnimation() { return ani; }
    
    private void setAnimation(int i, BufferedImage[] b, int d) {
        currentAnimation = i;
        ani.setFrames(b);
        ani.setDelay(d);
    }
    
    public void animate() {
        if(up) {
            if(currentAnimation != UP || ani.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 5);
            }
        }
        else if(down) {
            if(currentAnimation != DOWN || ani.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
            }
        }
        else if(left) {
            if(currentAnimation != LEFT || ani.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        }
        else if(right) {
            if(currentAnimation != RIGHT || ani.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }
    
    private void setHitBoxDirection() {
    	if(up) {
    		hitBounds.setYOffset(-size / 2);
    		hitBounds.setXOffset(-size / 2);
    	}
    	else if(down) {
    		hitBounds.setYOffset(size / 2);
    		hitBounds.setXOffset(-size / 2);
    	}
    	else if(left) {
    		hitBounds.setXOffset(-size);
    		hitBounds.setYOffset(0);
    	}
    	else if(right) {
    		hitBounds.setYOffset(0);
    		hitBounds.setXOffset(0);
    	}
    }

    public void update() {
        animate();
    	move();
    	setHitBoxDirection();
    	
        for(int i = 0; i < tm.getSheetCount(); i++) {
        	if(tm.getTileMap(i).getView() == 0) {
        		if(!bounds.collisionTile(0, dy, tm, tm.getTileMap(i))) {
                    pos.y += dy;
                    hitBounds.addY(dy);
                }
                if(!bounds.collisionTile(dx, 0, tm, tm.getTileMap(i))) {
                    pos.x += dx;
                    hitBounds.addX(dx);
                }
        	}
        }
        
        ani.update();
    }
    
    public abstract void render(Graphics2D g);
    public void input(InputHandler keys, MouseHandler mouse){}
}
