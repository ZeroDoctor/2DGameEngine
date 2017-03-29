package com.zerulus.game.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.zerulus.hub.GamePanel;

public class InputHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<Key>();

    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;

        public Key() {
            keys.add(this);
        }

        public void toggle(boolean pressed) {
            if(pressed != down) {
                down = pressed;
            }
            if(pressed) {
                presses++;
            }
        }

        public void tick() {
            if(absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();

    public Key zero = new Key();
    public Key one = new Key();
    public Key two = new Key();
    public Key three = new Key();
    public Key four = new Key();
    public Key five = new Key();
    public Key six = new Key();
    public Key seven = new Key();
    public Key eight = new Key();
    public Key nine = new Key();

    public Key edit = new Key();

    public Key event = new Key();

    public void releaseAll() {
        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    public void tick() {
        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public InputHandler(GamePanel gp) {
        gp.addKeyListener(this);
    }

    public void toggle(KeyEvent e, boolean pressed) {
        if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_B) menu.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_T) edit.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_E) event.toggle(pressed);

        if(e.getKeyCode() == KeyEvent.VK_0) zero.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_1) one.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_2) two.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_3) three.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_4) four.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_5) five.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_6) six.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_7) seven.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_8) eight.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_9) nine.toggle(pressed);

    }

    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }

    public void keyTyped(KeyEvent e) {}

}
