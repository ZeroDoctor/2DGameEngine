package com.zerulus.states;

import com.zerulus.hub.GamePanel;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.util.Vector2f;
import java.util.Vector;

public class TestBlock {

    private TileManager tm;

    private boolean notClicked = true;
    private boolean canEdit = false;

    private int tile = 0;
    private String num = "";

    public TestBlock(TileManager tm) {
        this.tm = tm;
    }

    private void addTile(int i) {
        num = num + String.valueOf(i);
    }

    private void makeTile() {
        if(num != "")
            tile = Integer.valueOf(num);
        else
            System.out.println("Tile Sprite not selected");

        num = "";
    }

    public void input(InputHandler keys, MouseHandler mouse) {

        keys.tick();

        if(canEdit) {
            if(keys.zero.clicked)
                addTile(0);
            if(keys.one.clicked)
                addTile(1);
            if(keys.two.clicked)
                addTile(2);
            if(keys.three.clicked)
                addTile(3);
            if(keys.four.clicked)
                addTile(4);
            if(keys.five.clicked)
                addTile(5);
            if(keys.six.clicked)
                addTile(6);
            if(keys.seven.clicked)
                addTile(7);
            if(keys.eight.clicked)
                addTile(8);
            if(keys.nine.clicked)
                addTile(9);
        }

        if(keys.enter.clicked) {
            makeTile();
        }


        if(keys.edit.clicked && canEdit == false) {
            System.out.println("Edit mode on");
            canEdit = true;
        }
        else if(keys.edit.clicked && canEdit == true) {
            System.out.println("Edit mode off");
            canEdit = false;
        }


        if(mouse.getButton() == 1 && notClicked) {
        	if(mouse.game.hasFocus()) {

                int x = (int) (mouse.getX() + (Vector2f.worldX + (Vector2f.worldX % 32)));
        		int y = (int) (mouse.getY() + (Vector2f.worldY + (Vector2f.worldY % 32)));


        		tm.addBlock(tile, new Vector2f((int) ( ((x - (x % (GamePanel.scale * 16) )) + (Vector2f.worldX - (Vector2f.worldX % (GamePanel.scale * 16))) ) / GamePanel.scale) ,
        				(int) ( ((y - (y % (GamePanel.scale * 16) )) + (Vector2f.worldY - (Vector2f.worldY % (GamePanel.scale * 16))) ) / GamePanel.scale)), 0);
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
