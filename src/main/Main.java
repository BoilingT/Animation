package main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import global.*;
import main.graphics.Canvas;

public class Main {
	
	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;

	private static WindowHandler window = new WindowHandler(WIDTH, HEIGHT, "Animation");
	private static Canvas canvas = new Canvas();

	
	private static void initWindowSize() {
		if (window != null) {
			JPanel sizePanel = new JPanel();
			sizePanel.setOpaque(false);
			sizePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			window.add(sizePanel);
			window.pack();
			sizePanel = null;
		}
	}
	
	public static void main(String[] args) {
		
		initWindowSize();
				
		window.getContentPane().add(canvas);
		window.Show();
	}

}
