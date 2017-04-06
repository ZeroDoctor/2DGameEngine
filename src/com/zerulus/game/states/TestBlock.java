package com.zerulus.game.states;

import com.zerulus.hub.GamePanel;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.InputHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;

public class TestBlock {

    private TileManager tm;

    private boolean notClicked = true;
    private int id;

    private int imageX;
    private int imageY;

    public TestBlock(TileManager tm) {
        this.tm = tm;
    }

    public void setTile(int imageX, int imageY) {
        this.imageX = imageX;
        this.imageY = imageY;
    }
    public void setId(int id) { this.id = id; }

    public void input(InputHandler keys, MouseHandler mouse) {

        keys.tick();


        if(mouse.getButton() == 1 && notClicked) {
        	if(mouse.game.hasFocus()) {

                int x = (int) (mouse.getX() + (Vector2f.worldX + (Vector2f.worldX % (GamePanel.scale * TileManager.minBlockSize) )));
        		int y = (int) (mouse.getY() + (Vector2f.worldY + (Vector2f.worldY % (GamePanel.scale * TileManager.minBlockSize) )));

        		tm.addBlock(imageX, imageY, new Vector2f(
                        (int) ( ((x - (x % (GamePanel.scale * TileManager.minBlockSize) )) + (Vector2f.worldX - (Vector2f.worldX % (GamePanel.scale * TileManager.minBlockSize))) ) / GamePanel.scale) ,
        				(int) ( ((y - (y % (GamePanel.scale * TileManager.minBlockSize) )) + (Vector2f.worldY - (Vector2f.worldY % (GamePanel.scale * TileManager.minBlockSize))) ) / GamePanel.scale)), id);

        	} else {
        		mouse.game.requestFocusInWindow();
        	}


            notClicked = false;
        }

        if(mouse.getButton() == 3 && notClicked) {

            int x = (int) (mouse.getX() + (Vector2f.worldX + (Vector2f.worldX % (GamePanel.scale * TileManager.minBlockSize) )));
            int y = (int) (mouse.getY() + (Vector2f.worldY + (Vector2f.worldY % (GamePanel.scale * TileManager.minBlockSize) )));

        	tm.removeBlock((int) ( ((x - (x % (GamePanel.scale * TileManager.minBlockSize) )) + (Vector2f.worldX - (Vector2f.worldX % (GamePanel.scale * TileManager.minBlockSize))) ) / GamePanel.scale) ,
                            (int) ( ((y - (y % (GamePanel.scale * TileManager.minBlockSize) )) + (Vector2f.worldY - (Vector2f.worldY % (GamePanel.scale * TileManager.minBlockSize))) ) / GamePanel.scale), id);
        	notClicked = false;
        }

        if(mouse.getButton() == -1) {
            notClicked = true;
        }

    }

}
