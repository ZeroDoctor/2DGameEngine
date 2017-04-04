package com.zerulus.game.states;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.game.entity.Enemy;
import com.zerulus.game.entity.Player;
import com.zerulus.game.graphics.Font;
import com.zerulus.game.graphics.Sprite;
import com.zerulus.hub.GamePanel;
import com.zerulus.game.tiles.TileManager;
import com.zerulus.game.tiles.TileMap;
import com.zerulus.game.util.InputHandler;
import com.zerulus.game.util.MouseHandler;
import com.zerulus.game.util.Vector2f;


public class PlayState  {

    // 2 - background
    // 1 - foreground
    // 0 - objects

    public static Vector2f map;

    private Player p;
    private ArrayList<Enemy> e;

    private Font f;

    private TileManager tm;

    private TestBlock tb;

    public PlayState() {

        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x, map.y);

        tm = new TileManager();
        tm.addTileMap(new TileMap("tiles\\dungeon_tiles_formatted.png", 16, 16));
        tm.setView(0, 0);

        p = new Player(new Sprite("entity\\linkFormatted.png"), new Vector2f(GamePanel.width + (GamePanel.width / 4 - 32), GamePanel.height + (GamePanel.height / 4 - 32)), tm);

        e = new ArrayList<Enemy>();
        e.add(new Enemy(new Sprite("entity\\linkFormatted.png"), new Vector2f(1000, 1000), tm));

        tb = new TestBlock(tm);

    }

    public TileManager getTileManager() { return tm; }
    public TestBlock getTestBlock() { return tb; }

    public void update() {
    	Vector2f.setWorldVar(map.x, map.y);
        if(p != null) {
        	for(int i = 0; i < e.size(); i++) {
        		e.get(i).update(p);
        	}

        	p.update(e);
        }

    }

    public void render(Graphics2D g) {
        tm.renderBack(g);
        tm.renderFore(g);
        tm.renderObj(g);

        if(p != null)
            p.render(g);

        for(int i = 0; i < e.size(); i++) {
    		e.get(i).render(g);
    	}

    }

    //place input in Player class ?
    public void input(InputHandler keys, MouseHandler mouse) {
        tb.input(keys, mouse);

        if(p != null)
            p.input(keys, mouse);
    }

}
