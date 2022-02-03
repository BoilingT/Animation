package main;

import java.awt.Color;

import global.math.Vector2;
import main.graphics.Drawing;
import main.graphics.ShapeObject;

public class DrawHandler {
	
	private Drawing draw;
	private ShapeObject rect;
	private ShapeObject rect2;
	
	public DrawHandler() {
		draw = Drawing.getInstance();
	}
	
	//Preparation
	public void setup() {
		System.out.println("Setup done!");
	}
	
	
	//Drawing
	public void draw() {
		rect = draw.addArc(new Vector2<Float>(0f, 0f), 100, 100, "Arc1");
		rect2 = draw.addArc(new Vector2<Float>(0f, 0f), 100, 100, "Arc2");
		draw.addRect(new Vector2<Float>(0f, 200f), 500, 100, "Rect1");
		rect.setFilled(true);
		rect.setColor(Color.black);
		System.out.println("Drawing done!");
	}
	
	float def = (float)(0.5 * Math.PI);
	float x = def;
	float a = 0.01f;
	float b = 2.5f;
	//Execution
	public void update() {
		//System.out.println("x: " + x);
		rect.setPos(new Vector2<Float>(200 + (float) (Math.sin(x+=a)*200), 200f + (float) Math.cos(x+=a)*200));
		rect2.setPos(new Vector2<Float>(200 + (float) Math.sin(x)*200, 200f));
		if (x > (float) (b*Math.PI)) {
			x = def;
			rect2.setFilled(!rect2.isFilled());
			rect.setFilled(!rect.isFilled());
		}
		sleep(10);
	}
	
	private void sleep(int ms) {
		try {
			
			Thread.sleep(ms);
		} catch (Exception e) {
			return;
		}
	}
}
