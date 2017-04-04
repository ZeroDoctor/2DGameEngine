package com.zerulus.hub.jtree;

import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
<<<<<<< HEAD:src/com/zerulus/hub/jtree/MyTree.java
import com.zerulus.hub.GamePanel;

public class MyTree extends JTree {

    public MyTree(TreeModel root, JTabbedPane jTabbedPane, GamePanel gp) {
        super(root);
        setDragEnabled(true);
        setDropMode(DropMode.ON_OR_INSERT);
        if(gp == null) System.out.println("WHATATAATA??!!!");
        setTransferHandler(new TreeTransferHandler(jTabbedPane, gp.getPlayState()));
=======

public class MyTree extends JTree {

    public MyTree(TreeModel root, JTabbedPane jTabbedPane) {
        super(root);
        setDragEnabled(true);
        setDropMode(DropMode.ON_OR_INSERT);
        setTransferHandler(new TreeTransferHandler(jTabbedPane));
>>>>>>> 990e84c8b2604b06c69e0a06ca462e0c9d638e4e:src/com/zerulus/hub/jtree/MyTree.java
        getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    }
}
