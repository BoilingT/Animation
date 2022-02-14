package windows.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import global.WindowHandler;
import main.graphics.Canvas;
import windows.console.ConsoleWindow;

public class MainWindow {
	
	private int WIDTH;
	private int HEIGHT;
	
	public MainWindow(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
	}
	
	private WindowHandler window = new WindowHandler(WIDTH, HEIGHT, "Animation");
	private Canvas canvas = new Canvas();
	private ConsoleWindow consoleWindow;
		
	private void initWindowSize() {
		if (window == null) return;
		JPanel sizePanel = new JPanel();
		sizePanel.setOpaque(false);
		sizePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//sizePanel.setSize(new Dimension(WIDTH, HEIGHT));
		window.getContentPane().add(sizePanel);
		window.pack();
		sizePanel = null;
	}
	
	public void init(Object[] objects) {
		consoleWindow = (ConsoleWindow) objects[0];
		initWindowSize();
					
		window.add(canvas);
		window.Show();		
	}
}
