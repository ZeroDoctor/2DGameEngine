package com.zerulus.game.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.hub.GamePanel;
import com.zerulus.game.util.Vector2f;

public class Block {

    private Vector2f pos;
    private int imageX;
    private int imageY;
    private int size;
    private BufferedImage img = null;

    private boolean once = true;

    public Block(int imageX, int imageY, int size, Vector2f pos, TileMap ts) {
        this.pos = pos;
        this.imageX = imageX;
        this.imageY = imageY;
        this.size = size;
        
        if((imageX + imageY * size) != -1)
            img = ts.getTileSprite().getSprite(imageX, imageY);
    }

    public int getId() { return (imageX + imageY * size); }

    public void update() {

    }

    public void render(Graphics2D g) {
        if(once) {
            System.out.println("TrueBlockPos: " + pos.getWorldVar().x + "," + pos.getWorldVar().y);
            once = false;
        }

        g.drawImage(img, (int) pos.getWorldVar().x, (int) pos.getWorldVar().y, size, size, null);
    }

}
