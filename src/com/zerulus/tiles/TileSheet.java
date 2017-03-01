package com.zerulus.tiles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.graphics.Sprite;
import com.zerulus.util.Vector2f;

public class TileSheet {

	private Sprite sprite;
	private ArrayList<Block> blocks;
	private int view = 0;

	public TileSheet(String file, int width, int height) {
		sprite = new Sprite(file, width, height);
		blocks = new ArrayList<Block>();
	}

	public void setView(int view) { this.view = view; }
	public int getView() { return view; }

	public Sprite getTileSheet() { return sprite; }

	public void addBlock(int id, int x, int y) {
		// the x and y could be the id of the block
		
		blocks.add(new Block(id, new Vector2f(x, y), this));
	}

	public void render(Graphics2D g) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}
}
