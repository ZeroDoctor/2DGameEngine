package com.zerulus.states;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zerulus.entity.Enemy;
import com.zerulus.entity.Player;
import com.zerulus.graphics.Font;
import com.zerulus.graphics.Sprite;
import com.zerulus.tiles.TileManager;
import com.zerulus.tiles.TileMap;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.util.Vector2f;


public class PlayState  {

    // 2 - background
    // 1 - foreground
    // 0 - objects

    private Vector2f map;

    private Player p;
    private ArrayList<Enemy> e;
    
    private Font f;
    
    private TileManager tm;

    private TestBlock tb;

    public PlayState() {

        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        
        tm = new TileManager();
        
        tm.addTileMap(new TileMap("\\res\\tiles\\dungeon_tiles_formatted.png", 16, 16));
        tm.setView(0, 0);
        
        p = new Player(new Sprite("\\res\\entity\\linkFormatted.png"), new Vector2f(200, 200), tm);
        e = new ArrayList<Enemy>();
        e.add(new Enemy(new Sprite("\\res\\entity\\linkFormatted.png"), new Vector2f(100, 100), tm));
        
        tb = new TestBlock(tm);
        
    }

    public void update() {
    	
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
