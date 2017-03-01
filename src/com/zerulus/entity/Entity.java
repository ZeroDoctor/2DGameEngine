package com.zerulus.entity;

import java.awt.Graphics2D;
import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;
import com.zerulus.util.AABB;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import java.awt.image.AffineTransformOp;

public abstract class Entity {

    protected Vector2f pos;
    protected Sprite sprite;

    public boolean up;
    public boolean down;
    public boolean right;
    public boolean left;

    protected float dx;
    protected float dy;
    protected int size;

    protected float maxSpeed = 2f;
    protected float acc = 1.5f;
    protected float deacc = 0.1f;

    protected AABB bounds;

    protected AffineTransformOp op;
    protected double rotation;

    public Entity(Sprite sprite, Vector2f orgin) {
        this.sprite = sprite;
        pos = orgin;
        size = Math.max(sprite.w, sprite.h);
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setSize(int i) { size = i; }
    public void setMaxSpeed(float i) { maxSpeed = i; }
    public void setAcc(float i) { acc = i; }
    public void setDeacc(float i) { deacc = i; }

    public abstract void update();
    public abstract void render(Graphics2D g);
    public void input(InputHandler keys, MouseHandler mouse){}
}
