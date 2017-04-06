package com.zerulus.hub.jtree;

import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import com.zerulus.hub.GamePanel;

public class MyTree extends JTree {
	private static final long serialVersionUID = 1L;

	public MyTree(TreeModel root, JTabbedPane jTabbedPane, GamePanel gp) {
        super(root);
        setDragEnabled(true);
        setDropMode(DropMode.ON_OR_INSERT);
        if(gp == null) System.out.println("WHATATAATA??!!!");
        setTransferHandler(new TreeTransferHandler(jTabbedPane, gp.getPlayState()));
    }
}
