package main.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.*;

import gloabl.math.Vector2;

public class Shapes {
	
	Graphics2D g;
	
	public void setGraphics2D(Graphics g) {
		this.g = (Graphics2D) g;
	}
	
	public boolean isNull() {
		return this.g == null;
	}
	
	public void reset() {
		g = null;
	}
	
	public static Rectangle2D.Float Rect(Vector2<Float> pos, float width, float height){
		return new Rectangle2D.Float(pos.getX(), pos.getY(), width, height);
	}
	
	public static Arc2D.Float Arc(Vector2<Float> pos, float width, float height) {
		return new Arc2D.Float(pos.getX(), pos.getY(), width, height, 0, 360, Arc2D.OPEN);
	}
	
	public void drawRect(Vector2<Float> pos, float width, float height, Color color) {
		Rectangle2D.Float rect = new Rectangle2D.Float(pos.getX(), pos.getY(), width, height);
		draw(rect, color);
	}
	
	public void fillRect(Vector2<Float> pos, float width, float height, Color color) {
		Rectangle2D.Float rect = new Rectangle2D.Float(pos.getX(), pos.getY(), width, height);
		fill(rect, color);
	}

	public void drawArc(Vector2<Float> pos, float width, float height, Color color) {
		Arc2D.Float arc = new Arc2D.Float(pos.getX(), pos.getY(), width, height, 0, 360, Arc2D.OPEN);
		draw(arc, color);
	}
	
	public void fillArc(Vector2<Float> pos, float width, float height, Color color) {
		Arc2D.Float arc = new Arc2D.Float(pos.getX(), pos.getY(), width, height, 0, 360, Arc2D.PIE);
		fill(arc, color);
	}
	
	public void draw(Shape s, Color color) {
		g.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.draw(s);
	}
	
	public void fill(Shape s, Color color) {
		g.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fill(s);
	}
}
