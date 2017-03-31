package com.zerulus.hub.tiletab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class TileSetTab extends JPanel {

    public TileSetTab(File f, Dimension size) {

        setLayout(null);

        JToolBar toolbar = new JToolBar();
        TileSet ts = new TileSet(f, size);

        JComboBox combSize = new JComboBox(new String[]{"8x8","16x16","32x32","64x64","128x128","256x256"});

        combSize.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                ts.setSelector(combSize.getSelectedItem().toString());
            }
        });

        toolbar.add(new JLabel("Size:"));
        toolbar.add(combSize);
        toolbar.setFloatable(false);
        toolbar.setMargin(new Insets(0, 0, 0, 5));
        add(toolbar);


        add(ts);

        Insets insets = getInsets();
        Dimension size1 = toolbar.getPreferredSize();
        toolbar.setBounds(5 + insets.left, insets.right, size1.width, size1.height);
        size1 = ts.getPreferredSize();
        ts.setBounds(5 + insets.left, 25 + insets.right, size1.width, size1.height);
    }


}
