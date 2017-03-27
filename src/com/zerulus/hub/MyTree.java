package com.zerulus.hub;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MyTree extends JTree {

    public MyTree() {
        super();
        setDragEnabled(false);
        setTransferHandler(new FSTransfer());
    }

}

class FSTransfer extends TransferHandler {

    public boolean importData(JComponent comp, Transferable t) {
        if (!(comp instanceof MyTree)) {
            return false;
        }
        

        if (!t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            return false;
        }

        MyTree tree = (MyTree) comp;
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        try {
            List data = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
            Iterator i = data.iterator();

            while (i.hasNext()) {
                File f = (File) i.next();
                System.out.println(f);
                root.add(new DefaultMutableTreeNode(f.getName()));
            }

            model.reload();
            return true;

        } catch (Exception ioe) {
            System.out.println(ioe);
        }
            return false;
    }

    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        if (comp instanceof MyTree) {
            for (int i = 0; i < transferFlavors.length; i++) {
                if (!transferFlavors[i].equals(DataFlavor.javaFileListFlavor)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
