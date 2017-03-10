package com.zerulus.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.zerulus.util.Vector2f;

public class Block {

	private Vector2f pos;
	private int id;
	private int size;
    private BufferedImage img = null;

	public Block(int id, int size, Vector2f pos, TileMap ts) {
		this.pos = pos;
		this.id = id;
		this.size = size;
        //this line LOL
		if(id != -1)
			img = ts.getTileSprite().getSprite(id / ts.getTileSprite().getWidth(), id % ts.getTileSprite().getWidth());
	}
	
	public int getId() { return id; }

	public void update() {

	}

	public void render(Graphics2D g) {
		g.drawImage(img, (int) pos.x, (int) pos.y, size, size, null);
	}

}
