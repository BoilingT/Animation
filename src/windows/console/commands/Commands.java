package windows.console.commands;

import java.awt.Color;
import java.util.HashMap;

import main.graphics.Drawing;

public class Commands {
	private Drawing draw; 
	private HashMap<String, Action> commands;
	
	public HashMap<String, Action> getCommands() {
		return commands;
	}
	
	public Commands() {
		draw = Drawing.getInstance();
		
		commands = new HashMap<>();
		addFunc("stop", new Action() {
			
			@Override
			public void run() {
				draw.stop();
			}
		});
		
		addFunc("play", new Action() {
			
			@Override
			public void run() {
				draw.play();
			}
		});
		
		addFunc("change color", new Action() {
			@Override
			public void run() {
				draw.getObject(0).setColor(Color.blue);
			}
		});
	}
	
	private void addFunc(String cmd, Action actionListener) {
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
		
		commands.get(cmd).run();
	}
}
