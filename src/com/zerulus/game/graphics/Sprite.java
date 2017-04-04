package com.zerulus.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.game.util.Vector2f;

public class Sprite {

    private final BufferedImage SPRITESHEET;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;


    public Sprite(String file) {
        w = TILE_SIZE;
        h = TILE_SIZE;
        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Sprite(String file, int w, int h) {
        this.w = w;
        this.h = h;
        System.out.println("Loading: " + file + "...");
        SPRITESHEET = loadSprite(file);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public Sprite(File f, int w, int h) {
        this.w = w;
        this.h = h;
        System.out.println("Loading: " + f.toString() + "...");
        SPRITESHEET = loadSprite(f);

        wSprite = SPRITESHEET.getWidth() / w;
        hSprite = SPRITESHEET.getHeight() / h;
        loadSpriteArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int i) {
        w = i;
        wSprite = SPRITESHEET.getWidth() / w;
    }

    public void setHeight(int i) {
        h = i;
        hSprite = SPRITESHEET.getWidth() / h;
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    private BufferedImage loadSprite(File f) {
        BufferedImage sprite = null;

        try{
            sprite = ImageIO.read(f);
        } catch(IOException e) {
            System.out.println("ERROR: could not load file: " + f.toString());
        }

        return sprite;
    }

    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;

        try{
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        } catch(IOException e) {
            System.out.println("ERROR: could not load file: " + file);
        }

        return sprite;
    }

    private void loadSpriteArray() {
        spriteArray = new BufferedImage[hSprite][wSprite];

        for(int y = 0; y < hSprite; y++) {
            for(int x = 0; x < wSprite; x++) {
                spriteArray[y][x] = getSprite(x,y);
            }
        }
    }

    //######################################getSprite###################################
    public BufferedImage getSpriteSheet() {
        return SPRITESHEET;
    }

    public BufferedImage getSprite(int x, int y) {
        return SPRITESHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(int i) {
        return spriteArray;
    }

    //######################################drawArray###################################
    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f vec, int width, int height, int xOffset, int yOffset) {
        float x = vec.x;
        float y = vec.y;
        for(int i = 0; i < img.size(); i++) {
            if(img.get(i) != null)
                g.drawImage(img.get(i), (int) x, (int) y, width, height, null);

            x += xOffset;
            y += yOffset;
        }
    }

    public static void drawArray(Graphics2D g, Font f, String word, Vector2f vec, int width, int height, int xOffset, int yOffset) {
        float x = vec.x;
        float y = vec.y;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != 32)
                g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);

            x += xOffset;
            y += yOffset;
        }
    }
}
