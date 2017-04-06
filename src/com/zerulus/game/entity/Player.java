package com.zerulus.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.game.graphics.Sprite;
import com.zerulus.game.states.PlayState;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.InputHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

public class Player extends Entity {



    public Player(Sprite sprite, Vector2f pos, TileManager tm) {
        super(sprite, pos, tm);
    }

    public Vector2f getPos() { return pos; }

    public void hit() {
    	System.out.println("PLAYER: I've been hit!");
    }

    private void checkTileCollision() {
    	for(int i = 0; i < tm.getSheetCount(); i++) {
            if(!bounds.collisionTile(0, dy, tm.getTileMap(i))) {
				if(PlayState.map.y >= 0) {
					PlayState.map.y += dy;
                    pos.y += dy;
                    hitBounds.addY(dy);
				} /*else {
					PlayState.map.y = 0;
					pos.y -= dy;
                    hitBounds.addY(-dy);
				}*/
            }
            if(!bounds.collisionTile(dx, 0, tm.getTileMap(i))) {
				if(PlayState.map.x >= 0) {
					PlayState.map.x += dx;
                    pos.x += dx;
                    hitBounds.addX(dx);
				} /*else {
					PlayState.map.x = 0;
					pos.x -= dx;
                    hitBounds.addX(-dx);
				}*/
            }
        }
    }

    public void update(ArrayList<Enemy> e) {
        super.update();
        checkTileCollision();
        if(attacking) {

            for(int i = 0; i < e.size(); i++) {
                //System.out.println("Hello");
                if(hitBounds.collides(e.get(i).getBounds()) ) {
                    e.get(i).hit();
                }
            }
        }

    }

    public void render(Graphics2D g) {

        g.setColor(Color.blue);
        g.drawRect((int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size / 2, size / 2);
        g.drawRect((int) (pos.getWorldVar().x) + size / 2, (int) (pos.getWorldVar().y), size / 2, size / 2);
        g.drawRect((int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y) + size / 2, size / 2, size / 2);
        g.drawRect((int) (pos.getWorldVar().x) + size / 2, (int) (pos.getWorldVar().y) + size / 2, size / 2, size / 2);

        g.setColor(Color.green);
        g.drawRect((int) ((pos.getWorldVar().x) + bounds.getXOffset()), (int) ((pos.getWorldVar().y) + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());

        if(attacking) {
            g.setColor(Color.red);
            g.drawRect((int) (hitBounds.getPos().getWorldVar().x + hitBounds.getXOffset()), (int) (hitBounds.getPos().getWorldVar().y + hitBounds.getYOffset()), (int) hitBounds.getWidth(), (int) hitBounds.getHeight());
        }

        g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
    }

    public void input(InputHandler keys, MouseHandler mouse) {
    	// For test purposes
    	if(keys.event.clicked) {
            bounds.setXOffset(3);
            bounds.setYOffset(14);
            bounds.setWidth(25);
            bounds.setHeight(16);
            acc = 0.2f;
    	}

    	if(keys.menu.clicked) {
            System.out.println("Bounds: " + bounds.getPos().x + ", " + bounds.getPos().y);
            System.out.println("Player: " + pos.x + ", " + pos.y);
    	}

        if(keys.up.down) {
            up = true;
        } else {
            up = false;
        }
        if(keys.down.down) {
            down = true;
        } else {
            down = false;
        }
        if(keys.left.down) {
            left = true;
        } else {
            left = false;
        }
        if(keys.right.down) {
            right = true;
        } else {
            right = false;
        }

        if(keys.attack.down) {
            //System.out.println("Hello");
            attacking = true;
        } else {
            attacking = false;
        }

    }
}
