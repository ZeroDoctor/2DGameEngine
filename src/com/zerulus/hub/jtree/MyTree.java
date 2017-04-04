package com.zerulus.hub.jtree;

import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import com.zerulus.hub.GamePanel;

public class MyTree extends JTree {

    public MyTree(TreeModel root, JTabbedPane jTabbedPane, GamePanel gp) {
        super(root);
        setDragEnabled(true);
        setDropMode(DropMode.ON_OR_INSERT);
        if(gp == null) System.out.println("WHATATAATA??!!!");
        setTransferHandler(new TreeTransferHandler(jTabbedPane, gp.getPlayState()));
        getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    }
}
