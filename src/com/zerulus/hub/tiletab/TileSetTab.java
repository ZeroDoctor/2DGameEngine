package com.zerulus.hub.tiletab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import com.zerulus.game.states.PlayState;
import com.zerulus.game.tiles.TileMap;

public class TileSetTab extends JPanel {
	private static final long serialVersionUID = 1L;

	public TileSetTab(File f, Dimension size, final PlayState ps, final int id) {

        setLayout(null);
        JToolBar toolbar = new JToolBar();
        TileMap tm = new TileMap(f, 8, 8);
        final TileSet ts = new TileSet(f, size, ps, id);

        ps.getTileManager().addTileMap(tm);
        JScrollPane scrollPane = new JScrollPane(ts);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        final JComboBox<String> combSize = new JComboBox<String>(new String[]{"8x8","16x16","32x32","64x64","128x128","256x256"});

        combSize.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {

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

    }

}
