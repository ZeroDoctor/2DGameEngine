package com.zerulus.states;

import java.awt.Graphics2D;

import com.zerulus.entity.Player;
import com.zerulus.entity.Entity;
import com.zerulus.graphics.Sprite;
import com.zerulus.graphics.Font;
import com.zerulus.tiles.TileMap;
import com.zerulus.tiles.TileManager;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;
import com.zerulus.util.Vector2f;


public class PlayState  {

    // 2 - background
    // 1 - foreground
    // 0 - objects

    private Vector2f map;

    private Player p;
    private Sprite playerSprite;
    private Vector2f playerPos;
    
    private Font f;
    
    private TileManager tm;

    private TestBlock tb;

    public PlayState() {

        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        
        tm = new TileManager();
        
        tm.addTileMap(new TileMap("\\res\\tiles\\dungeon_tiles_formatted.png", 16, 16));
        tm.setView(0, 0);

        playerSprite = new Sprite("\\res\\entity\\linkFormatted.png");
        playerPos = new Vector2f(200, 200);
        
        p = new Player(playerSprite, playerPos, tm);

        tb = new TestBlock(tm);
        
        
        tm.addBlock(0, 6 * 16, 3 * 16, 0);
    }

    public void update() {
        if(p != null)
            p.update();
    }

    public void render(Graphics2D g) {
        tm.renderBack(g);
        tm.renderFore(g);
        tm.renderObj(g);
        
        if(p != null)
            p.render(g);

    }

    //place input in Player class ?
    public void input(InputHandler keys, MouseHandler mouse) {
        tb.input(keys, mouse);
        
        if(p != null)
            p.input(keys, mouse);
    }

}
