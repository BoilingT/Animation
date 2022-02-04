package windows;

import javax.swing.JTextArea;

import global.WindowHandler;

public class ConsoleWindow {
	private WindowHandler output = new WindowHandler(300, 300, "Console");
	private JTextArea textArea = new JTextArea();
	
	public void init(Object[] objects) {
		textArea.setEditable(false);
		output.getContentPane().add(textArea);
		output.Show();
	}
	
	public void cout(String msg) {
		textArea.append(msg);
	}
}
