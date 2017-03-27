/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zerulus.hub;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author DanielCastro
 */
public class NodesTransferable implements Transferable {
    DefaultMutableTreeNode[] nodes;
    private DataFlavor[] flavors;
    private DataFlavor nodesFlavor;
    
    public NodesTransferable(DefaultMutableTreeNode[] nodes, DataFlavor[] flavors, DataFlavor nodesFlavor) {
        this.nodes = nodes;
        this.flavors = flavors;
        this.nodesFlavor = nodesFlavor;
     }

    public Object getTransferData(DataFlavor flavor)
                             throws UnsupportedFlavorException {
        if(!isDataFlavorSupported(flavor))
            throw new UnsupportedFlavorException(flavor);
        return nodes;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return nodesFlavor.equals(flavor);
    }
}
