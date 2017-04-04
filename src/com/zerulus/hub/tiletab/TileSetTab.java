package com.zerulus.hub.tiletab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JComboBox;
<<<<<<< HEAD
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import com.zerulus.game.tiles.TileMap;
import com.zerulus.game.states.PlayState;

public class TileSetTab extends JPanel {

    public TileSetTab(File f, Dimension size, PlayState ps, int id) {

        setLayout(null);
        JToolBar toolbar = new JToolBar();
        TileMap tm = new TileMap(f, 8, 8);
        TileSet ts = new TileSet(f, size, ps, id);

        ps.getTileManager().addTileMap(tm);
        JScrollPane scrollPane = new JScrollPane(ts);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
=======
import javax.swing.JToolBar;

public class TileSetTab extends JPanel {

    public TileSetTab(File f, Dimension size) {

        setLayout(null);

        JToolBar toolbar = new JToolBar();
        TileSet ts = new TileSet(f, size);
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e

        JComboBox combSize = new JComboBox(new String[]{"8x8","16x16","32x32","64x64","128x128","256x256"});

        combSize.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                String tempSize = combSize.getSelectedItem().toString();
                tempSize = tempSize.substring(0, tempSize.indexOf("x"));
                int temp = Integer.valueOf(tempSize);
                ts.setSelector(temp);

                ps.getTileManager().setTileMapSize(id + 1, temp, temp);
            }
        });

        toolbar.add(new JLabel("Size: "));
        toolbar.add(combSize);
        toolbar.setFloatable(false);
        toolbar.setMargin(new Insets(0, 0, 0, 5));
		setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
=======
                ts.setSelector(combSize.getSelectedItem().toString());
            }
        });

        toolbar.add(new JLabel("Size:"));
        toolbar.add(combSize);
        toolbar.setFloatable(false);
        toolbar.setMargin(new Insets(0, 0, 0, 5));
        add(toolbar);


        add(ts);
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e

        Insets insets = getInsets();
        Dimension size1 = toolbar.getPreferredSize();
        toolbar.setBounds(5 + insets.left, insets.right, size1.width, size1.height);
        size1 = ts.getPreferredSize();
        ts.setBounds(5 + insets.left, 25 + insets.right, size1.width, size1.height);
    }

<<<<<<< HEAD
=======

>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e
}
