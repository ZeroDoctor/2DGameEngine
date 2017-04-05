package com.zerulus.game.states;

import com.zerulus.hub.GamePanel;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.util.InputHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;
import java.util.Vector;

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

                int x = (int) (mouse.getX() + (Vector2f.worldX + (Vector2f.worldX % 32)));
        		int y = (int) (mouse.getY() + (Vector2f.worldY + (Vector2f.worldY % 32)));

        		tm.addBlock(imageX, imageY, new Vector2f((int) ( ((x - (x % (GamePanel.scale * 16) )) + (Vector2f.worldX - (Vector2f.worldX % (GamePanel.scale * 16))) ) / GamePanel.scale) ,
        				(int) ( ((y - (y % (GamePanel.scale * 16) )) + (Vector2f.worldY - (Vector2f.worldY % (GamePanel.scale * 16))) ) / GamePanel.scale)), id);
                        //- (int) ( (32 - (Vector2f.worldY % 32)) - (32 - (y % 32)) ) ), 0);

        	} else {
        		mouse.game.requestFocusInWindow();
        	}


            notClicked = false;
        }

        if(mouse.getButton() == 3 && notClicked) {
        	/*tm.removeBlock((mouse.getX() - (mouse.getX() % (GamePanel.scale * 16) )) / GamePanel.scale,
            		(mouse.getY() - (mouse.getY() % (GamePanel.scale * 16) )) / GamePanel.scale, 0);*/
        	notClicked = false;
        }

        if(mouse.getButton() == -1) {
            notClicked = true;
        }

    }

}
