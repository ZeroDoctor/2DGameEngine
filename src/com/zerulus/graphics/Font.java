package com.zerulus.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Font {

    public BufferedImage fontSheet;
    private int w;
    private int h;

    private int x;
    private int y;
    
    private int colImage;
    
    private HashMap<Character, Integer> hm;

    private String rootPath = System.getProperty("user.dir");

    public Font(String file, int w, int h) {
        this.w = w;
        this.h = h;
        hm = new HashMap<Character, Integer>();
        fontSheet = loadFont(rootPath + file);
        
        colImage = fontSheet.getWidth() / w;
    }

    private BufferedImage loadFont(String file) {
        BufferedImage font = null;
        try{
            font = ImageIO.read(new File(file));
        } catch(IOException e) {
            e.printStackTrace();
        }

        return font;
    }

    public BufferedImage getFont() {
        return fontSheet;
    }

    public BufferedImage getFont(char letter) {
    	
    	int value = hm.get(letter);
    	x = value % colImage;
    	y = value / colImage;
    	
    	return fontSheet.getSubimage(x, y, w, h);
    }
    
    public void addLetter(int c, int r, Character letter) {
    	hm.put(letter, c + (r * colImage));
    }


}
