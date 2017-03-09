package com.zerulus.hub;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.states.PlayState;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private Thread thread;
    private Graphics2D g;
    private BufferedImage img;
    private boolean running;

    public static int width;
    public static int height;

    private InputHandler keys;
    private MouseHandler mouse;
    private PlayState ps;

    public GamePanel(int width, int height) {
        GamePanel.width = width;
        GamePanel.height = height;

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void init() {
        running = true;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();


        ps = new PlayState();
        keys = new InputHandler(this);
        mouse = new MouseHandler(this);

    }

    public void run() {
        init();

        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000 / GAME_HERTZ;
        //most update before render
        final int MUBR = 5;

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double TTBR = 1000000000 / TARGET_FPS;

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);

        while(running) {

            double now = System.nanoTime();
            int updateCount = 0;

            while(((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                input(keys, mouse);
                lastUpdateTime += TBU;
                updateCount++;
            }

            if(now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }

            input(keys, mouse);
            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
            while (now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
                //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
                //FYI on some OS's this can cause pretty bad stuttering.
                //Scroll down and have a look at different peoples' solutions to this.
                try {Thread.sleep(1);} catch(Exception e) { System.out.print("Error in Thread-1");}

                now = System.nanoTime();
            }
        }

    }

    public void update() {
        ps.update();
    }

    public void input(InputHandler keys, MouseHandler mouse) {
        ps.input(keys, mouse);
    }

    public void render() {
        if(g != null) {
            g.setColor(Color.black);
            g.fillRect(0, 0, width, height);
            ps.render(g);
        }


    }

    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0, 0, width * 2, height * 2, null);
        g2.dispose();
    }

}
