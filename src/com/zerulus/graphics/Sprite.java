package com.zerulus.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.util.ArrayList;
import com.zerulus.util.Vector2f;

public class Sprite {

    private BufferedImage spriteSheet;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    public int w;
    public int h;
    private int wSprite;
    private int hSprite;

    private String rootPath = System.getProperty("user.dir");

    public Sprite(String file) {
        w = TILE_SIZE;
        h = TILE_SIZE;
        spriteSheet = loadSprite(rootPath + file);

        wSprite = spriteSheet.getWidth() / w;
        hSprite = spriteSheet.getHeight() / h;
        loadSpriteArray();
    }

    public Sprite(String file, int w, int h) {
        this.w = w;
        this.h = h;

        spriteSheet = loadSprite(rootPath + file);

        wSprite = spriteSheet.getWidth() / w;
        hSprite = spriteSheet.getHeight() / h;
        loadSpriteArray();
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try{
            //System.out.println(file);
            sprite = ImageIO.read(new File(file));
        } catch(IOException e) {
            e.printStackTrace();
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
        return spriteSheet;
    }

    public BufferedImage getSprite(int x, int y) {
        return spriteSheet.getSubimage(x * w, y * h, w, h);
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
