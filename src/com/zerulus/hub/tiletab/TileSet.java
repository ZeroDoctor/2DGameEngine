package com.zerulus.hub.tiletab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

<<<<<<< HEAD
import com.zerulus.game.states.PlayState;


=======
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e

public class TileSet extends JPanel {

    private File f;
    private BufferedImage image;
    private BufferedImage test;

    private TabMouseHandler mouse;
    private Dimension size;
    private int tilesetWidth;
    private int tilesetHeight;
<<<<<<< HEAD

    private int xSelector = 0;
    private int ySelector = 0;
    private int sizeSelector = 8;

    private int width = 0;
    private int height = 0;

    public TileSet(File f, Dimension size, PlayState ps, int id) {
        this.f = f;
        this.size = size;

=======
    private int sizeSelector = 8;

    public TileSet(File f, Dimension size) {
        this.f = f;
        this.size = size;
        setPreferredSize(new Dimension(1000,1000));

        System.out.println(size);
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e

        try {
            image = ImageIO.read(f);
        } catch(Exception e) {
            System.out.println("Can't Find the File " + f);
            e.printStackTrace();
        }

<<<<<<< HEAD
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
=======
        mouse = new TabMouseHandler();
        addMouseListener(mouse);
        System.out.println("Here1");
        test = setImageSize();
    }

    public void setSelector(String sizeSelector) {
        String tempSize = sizeSelector.substring(0, sizeSelector.indexOf("x"));
        this.sizeSelector = Integer.valueOf(tempSize);
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e
    }

    public BufferedImage setImageSize() {
        BufferedImage img = null;

        int temp = image.getWidth();

<<<<<<< HEAD
        if(size.getWidth() < image.getWidth()) {
            while(temp > size.getWidth()) {
                temp = temp - sizeSelector;

            }

=======
        if(size.getWidth() + 175 < image.getWidth()) {
            while(temp > size.getWidth() + 175) {
                temp = temp - sizeSelector;

            }
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e
            img = image.getSubimage(temp, 0, image.getWidth() - temp, image.getHeight());
        }


        return img;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

<<<<<<< HEAD
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);

        if(test != null)
            g.drawImage(test, 0, image.getWidth(), test.getWidth(), test.getHeight(), null);


        g.setColor(Color.RED);
        g.drawRect(xSelector, ySelector, sizeSelector, sizeSelector);
=======
        g.setColor(Color.RED);
        g.drawRect(0, 0, sizeSelector / 2, sizeSelector / 2);


        g.drawImage(image, 0, 0, (int) sizeSelector * 4, (int) image.getHeight(), null);

        if(test != null)
            g.drawImage(test, 0, 0, sizeSelector * 4, image.getHeight(), null);

>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e

        repaint();
    }

}
