package com.zerulus.hub.tiletab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;


public class TileSet extends JPanel {

    private File f;
    private BufferedImage image;
    private BufferedImage test;

    private TabMouseHandler mouse;
    private Dimension size;
    private int tilesetWidth;
    private int tilesetHeight;
    private int sizeSelector = 8;

    public TileSet(File f, Dimension size) {
        this.f = f;
        this.size = size;
        setPreferredSize(new Dimension(1000,1000));

        System.out.println(size);

        try {
            image = ImageIO.read(f);
        } catch(Exception e) {
            System.out.println("Can't Find the File " + f);
            e.printStackTrace();
        }

        mouse = new TabMouseHandler();
        addMouseListener(mouse);
        System.out.println("Here1");
        test = setImageSize();
    }

    public void setSelector(String sizeSelector) {
        String tempSize = sizeSelector.substring(0, sizeSelector.indexOf("x"));
        this.sizeSelector = Integer.valueOf(tempSize);
    }

    public BufferedImage setImageSize() {
        BufferedImage img = null;

        int temp = image.getWidth();

        if(size.getWidth() + 175 < image.getWidth()) {
            while(temp > size.getWidth() + 175) {
                temp = temp - sizeSelector;

            }
            img = image.getSubimage(temp, 0, image.getWidth() - temp, image.getHeight());
        }


        return img;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawRect(0, 0, sizeSelector / 2, sizeSelector / 2);


        g.drawImage(image, 0, 0, (int) sizeSelector * 4, (int) image.getHeight(), null);

        if(test != null)
            g.drawImage(test, 0, 0, sizeSelector * 4, image.getHeight(), null);


        repaint();
    }

}
