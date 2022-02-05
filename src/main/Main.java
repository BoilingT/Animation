package main;

import windows.console.ConsoleWindow;
import windows.main.MainWindow;

public class Main {
	
	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;

	private static MainWindow mainWindow = new MainWindow(WIDTH, HEIGHT);
	private static ConsoleWindow consoleWindow;
	
	public static void main(String[] args) {
		consoleWindow = ConsoleWindow.getInstance();
		consoleWindow.init(null);
		mainWindow.init(new Object[] {consoleWindow});
	}

}
