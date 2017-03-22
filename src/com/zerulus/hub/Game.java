package com.zerulus.hub;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;

	public Game(String title, int width, int height) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(width, height));
        pack();
        setVisible(true);
    }

    public Game(String title) {

        int width = 1920;
        int height = 1080;
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);


        setContentPane(new GamePanel(width, height));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}