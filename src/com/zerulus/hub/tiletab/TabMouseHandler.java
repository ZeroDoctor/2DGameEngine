package com.zerulus.hub.tiletab;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import com.zerulus.game.states.PlayState;

public class TabMouseHandler implements MouseListener, MouseMotionListener{

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    private int x;
    private int y;

    private TileSet ts;
    private int id;
    private PlayState ps;

    public TabMouseHandler(TileSet ts, PlayState ps, int id) {
        this.ts = ts;
        this.id = id;
        this.ps = ps;
    }

    public int getX() {
        return mouseX;
    }

    public int getY() {
        return mouseY;
    }

    public int getButton() {
        return mouseB;
    }

    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX() - (e.getX() % ts.getSizeSelector());
        y = e.getY() - (e.getY() % ts.getSizeSelector());

        ts.setSelectorX(x);
        ts.setSelectorY(y);
        System.out.println(id + 1);
        ps.getTestBlock().setId(id + 1);
        ps.getTestBlock().setTile(x + y * ts.getSizeSelector());

    }

    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
