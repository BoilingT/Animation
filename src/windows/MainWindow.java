package windows;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import global.WindowHandler;
import main.graphics.Canvas;

public class MainWindow {
	
	private int WIDTH;
	private int HEIGHT;
	
	public MainWindow(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
	}
	
	private WindowHandler window = new WindowHandler(WIDTH, HEIGHT, "Animation");
	private Canvas canvas = new Canvas();

	private static MouseListener listener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private void initWindowSize() {
		if (window != null) {
			JPanel sizePanel = new JPanel();
			sizePanel.setOpaque(false);
			sizePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
			window.add(sizePanel);
			window.pack();
			sizePanel = null;
		}
	}
	
	public void init(Object[] objects) {
		initWindowSize();
		
		canvas.addMouseListener(listener);
		window.getContentPane().add(canvas);
		window.Show();
	}
}
