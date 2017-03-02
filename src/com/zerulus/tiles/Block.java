package com.zerulus.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;

public class Block {

	private Vector2f pos;
        private BufferedImage img;

	public Block(int id, Vector2f pos, TileSheet ts) {
		this.pos = pos;
                //this line LOL
                img = ts.getTileSheet().getSprite(id / ts.getTileSheet().getWidth(), id % ts.getTileSheet().getWidth());
	}

	public void update() {

	}

	public void render(Graphics2D g) {
		// later implement the width and height
		g.drawImage(img, (int) pos.x, (int) pos.y, null);
	}

}
