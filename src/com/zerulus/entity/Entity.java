package com.zerulus.entity;

import java.awt.Graphics2D;
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

    protected float dx;
    protected float dy;
    protected int size;

    protected float maxSpeed = 2f;
    protected float acc = 1f;
    protected float deacc = 0.1f;

    protected AABB bounds;
    
    private TileManager tm;

    public Entity(Sprite sprite, Vector2f orgin) {
        this.sprite = sprite;
        pos = orgin;
        size = Math.max(sprite.w, sprite.h);
        bounds = new AABB(orgin, size, size);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public void setTileManager(TileManager tm) { this.tm = tm; }

    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float i) { maxSpeed = i; }
    public void setAcc(float i) { acc = i; }
    public void setDeacc(float i) { deacc = i; }
    
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

    public void update() {
        move();

        if(!bounds.collisionTile(0, dy, tm)) {
            pos.y += dy;
        }
        if(!bounds.collisionTile(dx, 0, tm)) {
            pos.x += dx;
        }
    }
    public abstract void render(Graphics2D g);
    public void input(InputHandler keys, MouseHandler mouse){}
}
