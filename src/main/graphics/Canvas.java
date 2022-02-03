package main.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.DrawHandler;

public class Canvas extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;

	private int WIDTH;
	private int HEIGHT;
	
	private final Shapes drawer = new Shapes();
	private final DrawHandler drawHandler = new DrawHandler();
	public long updateDelay = 1;
	private boolean running = true;
	
	
	public Canvas() {
		setup();
	}
	
	//Setup
	private void setup() {
		drawHandler.setup();
		drawHandler.draw();
		//Background:
//		ShapeObject obj = new ShapeObject(GraphicsHandler.Rect(new Vector2<Float>(0f, 0f), this.WIDTH, this.HEIGHT), Color.red, true); 
//		//objects.add(obj);
//
//		//Objects:
//		obj = new ShapeObject(GraphicsHandler.Rect(new Vector2<Float>(100f, 100f), 50, 50), Color.red, true); 
//		addShape(obj);
//		obj = new ShapeObject(GraphicsHandler.Arc(new Vector2<Float>(200f, 100f), 20, 20), Color.red, false); 
//		addShape(obj);
		
		repaint();
	}
	
	
	//Logic
	private void update() {
		drawHandler.update();
//		getObject(0).translate(new Vector2<Float>(10f,0f));
//		getObject(1).translate(new Vector2<Float>(10f,10f));
//		System.out.println(getObject(1).getPos().toString());
//		getObject(1).setFilled(!getObject(1).isFilled());
	}
	
	//Drawing
	@Override
	public void paintComponent(Graphics g1) {
		this.HEIGHT = this.getHeight();
		this.WIDTH = this.getWidth();
		Graphics2D g = (Graphics2D) g1;
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		drawer.setGraphics2D(g);
		if (drawer.isNull()) {
			System.out.println("Graphics isn't set");
			return;
		}
		
		Drawing drawing = Drawing.getInstance();
		
		if (drawing != null) {
			for (ShapeObject object : drawing.getObjects()) {
				if (object.getShape() != null) {
					if(object.isFilled()) {
						drawer.fill(object.getShape(), object.getColor());
					}else if(!object.isFilled()){					
						drawer.draw(object.getShape(), object.getColor());
					}
				}
			}			
		}
		
	}
	
	private void wait(int ms) {
		try {
			Thread.sleep(ms);
			
		} catch (Exception e) {
			running = false;
			String msg = String.format("Thread interrupted: %s", e.getMessage());
            
            JOptionPane.showMessageDialog(this, msg, "Error", 
				JOptionPane.ERROR_MESSAGE);
            return;
		}
		
		return;
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		//updateThread = new Thread(this);
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		long lastTime, timeDiff, delay;
		
		lastTime = System.currentTimeMillis();
		
		while(running) {
			
			this.update();
			this.repaint();
			
			timeDiff = System.currentTimeMillis() - lastTime;
			delay = updateDelay - timeDiff;
//			System.out.println("Time Diff: " + timeDiff + " ms");
//			System.out.println("Delay: " + delay + " ms");
			
			if (delay < 0) {
				lastTime = System.currentTimeMillis();
				continue;
			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				String msg = String.format("Thread interrupted: %s", e.getMessage());
                
                JOptionPane.showMessageDialog(this, msg, "Error", 
					JOptionPane.ERROR_MESSAGE);
                running = false;
                return;
			}
			
			lastTime = System.currentTimeMillis();
		}
	}

}
