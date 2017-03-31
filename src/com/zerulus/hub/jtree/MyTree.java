package com.zerulus.hub.jtree;

import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

public class MyTree extends JTree {

    public MyTree(TreeModel root, JTabbedPane jTabbedPane) {
        super(root);
        setDragEnabled(true);
        setDropMode(DropMode.ON_OR_INSERT);
        setTransferHandler(new TreeTransferHandler(jTabbedPane));
        getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    }
}
