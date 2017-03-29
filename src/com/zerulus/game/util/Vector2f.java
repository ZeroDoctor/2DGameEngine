package com.zerulus.game.util;


public class Vector2f {

    public float x;
    public float y;

    public static float worldX;
    public static float worldY;

    public Vector2f() {
        x = 0;
        y = 0;
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addX(float i) { x += i; }
    public void addY(float i) { y += i; }

    public void setX(float i) { x = i; }
    public void setY(float i) { y = i; }

    public void setVector(Vector2f vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public void setVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static void setWorldVar(float x, float y) {
        worldX = x;
        worldY = y;
    }

    public Vector2f getWorldVar() {
    	return new Vector2f(x - worldX, y - worldY);
    }

    public Vector2f getTileWorldVar() {
        return new Vector2f(x + worldX, y + worldY);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

}
