package com.zerulus.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Font {

    public BufferedImage fontSheet;
    private final int TILE_SIZE = 16;
    private int w;
    private int h;

    private int c;
    private int r;

    private String rootPath = System.getProperty("user.dir");

    public Font(String file) {
        w = TILE_SIZE;
        h = TILE_SIZE;
        c = 10;
        r = 10;
        fontSheet = loadFont(rootPath + file);
    }

    public Font(String file, int w, int h, int c, int r) {
        this.w = w;
        this.h = h;

        this.c = c;
        this.r = r;

        fontSheet = loadFont(rootPath + file);
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
        int a = 0;

        a = letter;

        if(Character.isDigit(letter)) {
            a = a - 48;
        }


        switch(a) {
            case 45: a = 91;
                break;
            case 46: a = 92;
                break;
            case 44: a = 93;
                break;
            case 60:a = 94;
                break;
            case 62:a = -94;
                break;
            case 33:a = 95;
                break;
            case 63:a = 96;
                break;
        }

        if (a == 94) {
            return fontSheet.getSubimage( ((a - 65) % c) * w, ((int) ((a - 65) / r)) * h, w / 2, h);
        } else if (a == -94) {
            a = 94;
            return fontSheet.getSubimage( ((a - 65) % c) * w + (w / 2), ((int) ((a - 65) / r)) * h, w / 2, h);
        } else if(a >= 0 && a <= 9) {
            return fontSheet.getSubimage(a * w, 6 * h, w, h);
        } else {
            return fontSheet.getSubimage( ((a - 65) % c) * w, ((int) ((a - 65) / r)) * h, w, h);
        }

    }


}
