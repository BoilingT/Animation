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
		
		addFunc("setColor", new Action() {
			@Override
			public void run(String args) {
				System.out.println("Args: " + args);
				String[] values;
				Color newColor = null;
				int index = -1;
				try {
					values = getArgs(args);
					if(values.length != 4) return;
					int r, g, b;
					index = Integer.parseInt(values[0]);
					r = Integer.parseInt(values[1]);
					g = Integer.parseInt(values[2]);
					b = Integer.parseInt(values[3]);
					if((float)(r+g+b)/3 > 255) {
						System.out.println("To high!");
					}
					newColor = new Color(r, g, b);
					
				}catch (Exception e) {
					System.out.println("Could not parse!");
					System.out.println(e.getMessage());
					return;
				}
				for(int i = 0; i < values.length; i++) {
					System.out.println("Value " + i + ": " + values[i]);					
				}
				if(index > draw.getObjects().size()) return;
				draw.getObject(index).setColor(newColor);
			}
		});
	}
	
	private String[] getArgs(String args) {
		return args.substring(args.indexOf('(')+1, args.indexOf(')')).split("[, ]+");
	}
	
	private void addFunc(String cmd, Action actionListener) {
		if (commands == null) {
			System.out.println("commands = null");
			return;
		}
		System.out.println(cmd + " added");
		commands.put(cmd, actionListener);
	}
	
	public void run(String cmd, String args) {
		String[] argsArr = args.split("\\n");
		args = "";
		for (int i = 0; i < argsArr.length; i++) {
			args += argsArr[i];
		}
		if (commands == null) {
			System.out.println("commands = null");
			return;
		}
		if (args.length() > 0) {
			commands.get(cmd).run(args);			
		}else {
			commands.get(cmd).run();			
		}
	}
}
