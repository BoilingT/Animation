package windows.console;

import java.util.HashMap;

import main.graphics.Drawing;

public class Commands {
	private Drawing draw; 
	private HashMap<String, IAction> commands;
	
	public HashMap<String, IAction> getCommands() {
		return commands;
	}
	
	public Commands() {
		draw = Drawing.getInstance();
		
		commands = new HashMap<>();
		addFunc("stop", new IAction() {
			
			@Override
			public void run() {
				draw.stop();
				System.out.println("PAUSE");
			}
		});
		
		addFunc("play", new IAction() {
			
			@Override
			public void run() {
				draw.play();
				System.out.println("PAUSE");
			}
		});
	}
	
	private void addFunc(String cmd, IAction actionListener) {
		if (commands == null) {
			System.out.println("commands = null");
			return;
		}
		System.out.println(cmd + " added");
		commands.put(cmd, actionListener);
	}
	
	public void run(String cmd) {
		if (commands == null) {
			System.out.println("commands = null");
			return;
		}
		
		System.out.println(cmd + " ran");

		commands.get(cmd).run();
	}
}
