package com.zerulus.hub.tiletab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.zerulus.game.states.PlayState;



public class TileSet extends JPanel {

    private File f;
    private BufferedImage image;
    private BufferedImage test;

    private TabMouseHandler mouse;
    private Dimension size;
    private int tilesetWidth;
    private int tilesetHeight;

    private int xSelector = 0;
    private int ySelector = 0;
    private int sizeSelector = 8;

    private int width = 0;
    private int height = 0;

    public TileSet(File f, Dimension size, PlayState ps, int id) {
        this.f = f;
        this.size = size;


        try {
            image = ImageIO.read(f);
        } catch(Exception e) {
            System.out.println("Can't Find the File " + f);
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        setPreferredSize(new Dimension(width, height));
		System.out.println(width + "," + height);

        mouse = new TabMouseHandler(this, ps, id);
        addMouseListener(mouse);
        test = setImageSize();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setSelectorX(int i) { xSelector = i; }
    public void setSelectorY(int i) { ySelector = i; }
    public int getSizeSelector() { return sizeSelector; }

    public void setSelector(int sizeSelector) {
        this.sizeSelector = sizeSelector;
    }

    public BufferedImage setImageSize() {
        BufferedImage img = null;

        int temp = image.getWidth();

        if(size.getWidth() < image.getWidth()) {
            while(temp > size.getWidth()) {
                temp = temp - sizeSelector;

            }

            img = image.getSubimage(temp, 0, image.getWidth() - temp, image.getHeight());
        }


        return img;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);

        if(test != null)
            g.drawImage(test, 0, image.getWidth(), test.getWidth(), test.getHeight(), null);


        g.setColor(Color.RED);
        g.drawRect(xSelector, ySelector, sizeSelector, sizeSelector);

        repaint();
    }

}
