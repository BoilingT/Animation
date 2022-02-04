package main;

import global.*;
import windows.ConsoleWindow;
import windows.MainWindow;


public class Main {
	
	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;

	private static MainWindow mainWindow = new MainWindow(WIDTH, HEIGHT);
	private static ConsoleWindow consoleWindow = new ConsoleWindow();
	
	public static void main(String[] args) {
		
		mainWindow.init();
		consoleWindow.init();
	}

}
