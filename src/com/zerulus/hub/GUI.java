package com.zerulus.hub;

import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

import com.zerulus.hub.jtree.MyTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshua Powell
 */





public class GUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	/**
     * Creates new form GUI
     */
    public GUI() {
		GamePanel gp = new GamePanel(800, 600);
        initComponents(gp);
        addGamePanel(gp);
    }

    private void addGamePanel(GamePanel gp) {
        jTabbedPane3.addTab("Game.amx", gp);
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(GamePanel gp) {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jComboBox4 = new javax.swing.JComboBox<String>();
		jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultMutableTreeNode layers = new DefaultMutableTreeNode("Layers");
        DefaultMutableTreeNode background = new DefaultMutableTreeNode("Background");
        DefaultMutableTreeNode foreground = new DefaultMutableTreeNode("Foreground");
        DefaultMutableTreeNode objects = new DefaultMutableTreeNode("Objects");

        layers.add(background);
        layers.add(foreground);
        layers.add(objects);

		DefaultTreeModel root = new DefaultTreeModel(layers, true);
        jTree1 = new MyTree(root, jTabbedPane4, gp);
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        newProject = new javax.swing.JMenuItem();
        openProject = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        saveAs = new javax.swing.JMenuItem();
        Import = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Insert = new javax.swing.JMenuItem();
        Duplicate = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        Resources = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        ToolBox = new javax.swing.JMenuItem();
        ViewOptions = new javax.swing.JMenuItem();
        MinimizeViews = new javax.swing.JMenuItem();
        CloseViews = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();


        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);      	
        
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

		jPopupMenu1.setToolTipText("remove");
        jPopupMenu1.setLabel("");

		jMenuItem2.setText("remove");

		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("AdventureMaker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

		jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jSplitPane2.setDividerLocation(950);

        jTabbedPane1.setAlignmentX(100.0F);
        jTabbedPane1.setAlignmentY(100.0F);
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(250, 240));
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setRequestFocusEnabled(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Sprite", "Player Properties", "Enemy", "Item Properties", "Sounds" }));
        jComboBox1.setName("Sprite editor"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Font" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Scene", "Grid", "Sounds" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Objects" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(558, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel3);
        jTabbedPane1.setTitleAt(0, "Project Explorer");

        jSplitPane1.setLeftComponent(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Project Explorer");
        jTabbedPane1.getAccessibleContext().setAccessibleParent(jSplitPane1);

        jTabbedPane3.setAlignmentX(100.0F);
        jTabbedPane3.setAlignmentY(100.0F);
        jTabbedPane3.setMinimumSize(new java.awt.Dimension(100, 100));
        jTabbedPane3.setPreferredSize(new java.awt.Dimension(800, 600));
        jSplitPane1.setRightComponent(jTabbedPane3);

        jSplitPane2.setLeftComponent(jSplitPane1);

        jTabbedPane2.setToolTipText("Layers");
        jTabbedPane2.setName("Layers"); // NOI18N
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(25, 389));

        jTree1.setToolTipText("Layers");
        jTree1.setName("Layers"); // NOI18N
		jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);
        jTree1.getAccessibleContext().setAccessibleName("Layers");

        jTabbedPane2.addTab("tab1", jScrollPane1);
        jTabbedPane2.setTitleAt(0, "Layers");

		jPanel4.add(jTabbedPane2);
		jPanel4.add(jTabbedPane4);

        jSplitPane2.setRightComponent(jPanel4);
        jTabbedPane2.getAccessibleContext().setAccessibleName("Layers");

        jPanel1.add(jSplitPane2);

        jPanel2.add(jPanel1);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        newProject.setText("New Project");
        jMenu3.add(newProject);
        	newProject.addActionListener(new java.awt.event.ActionListener(){
        		public void actionPerformed(java.awt.event.ActionEvent evt) {
        			
        		}
        	});
        	
        openProject.setText("Open Project");
        jMenu3.add(openProject);
        	openProject.addActionListener(new java.awt.event.ActionListener(){
        		public void actionPerformed(java.awt.event.ActionEvent evt){  			
        			
        		}
        	});
        Save.setText("Save");
        jMenu3.add(Save);

        saveAs.setText("Save as");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String userHomeFolder = System.getProperty("user.home");
    			File dir = new File(userHomeFolder,"GameProject");
    			dir.mkdir();
            }
        });
        jMenu3.add(saveAs);

        Import.setText("Import");
        jMenu3.add(Import);

        Exit.setText("Exit");
        jMenu3.add(Exit);
        
        Exit.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}       	
        });

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenu6.add(Insert);

        Duplicate.setText("Duplicate");
        Duplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenu6.add(Duplicate);

        Delete.setText("Delete");
        jMenu6.add(Delete);

        Resources.setText("Resources");
        jMenu6.add(Resources);

        jMenu4.setText("View");
        jMenuBar2.add(jMenu4);

        ToolBox.setText("Toolbox");
        ToolBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenu4.add(ToolBox);

        ViewOptions.setText("View Options");
        jMenu4.add(ViewOptions);

        MinimizeViews.setText("Minimize Views");
        jMenu4.add(MinimizeViews);

        CloseViews.setText("Close Views");
        jMenu4.add(CloseViews);


        jMenu7.setText("Load");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Help");
        jMenuBar2.add(jMenu8);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, screenSize.width, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, screenSize.height - 90, Short.MAX_VALUE)
        );

		pack();
		setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jTabbedPane1.addTab("Sprite", jPanel3);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

	private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = jTree1.getClosestRowForLocation(evt.getX(), evt.getY());
            if(jTree1.getPathForRow(row).getPathCount() > 2) {
                jTree1.setSelectionRow(row);
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTree1MouseClicked

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		DefaultTreeModel temp = (DefaultTreeModel) jTree1.getModel();
		temp.removeNodeFromParent((MutableTreeNode) jTree1.getSelectionPath().getLastPathComponent());
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseViews;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Duplicate;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Import;
    private javax.swing.JMenuItem Insert;
    private javax.swing.JMenuItem MinimizeViews;
    private javax.swing.JMenuItem Resources;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem ToolBox;
    private javax.swing.JMenuItem ViewOptions;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
	private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuItem newProject;
    private javax.swing.JMenuItem openProject;
    private javax.swing.JMenuItem saveAs;
    // End of variables declaration//GEN-END:variables
}
