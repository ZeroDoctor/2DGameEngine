package com.zerulus.tiles;

import java.awt.Graphics2D;

import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;

public class Block {

	private Vector2f pos;
	private TileSheet ts;
	private int id;

	public Block(int id, Vector2f pos, TileSheet ts) {
		this.ts = ts;
		this.pos = pos;
		this.id = id;
		// get the width and height of the tileSheet
		// and the columns, so based on that
		// get the Block img from the tileSheet
	}

	public void update() {

	}

	public void render(Graphics2D g) {
		// later implement the width and height
		g.drawImage(ts.getTileSheet().getSprite(id / ts.getTileSheet().getWidth(), id % ts.getTileSheet().getWidth()), (int) pos.x, (int) pos.y, null);
	}

}
