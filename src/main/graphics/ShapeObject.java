package main.graphics;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import gloabl.math.Vector2;

public class ShapeObject {

	private String name;
	private Vector2<Float> pos;
	private Color color;
	private boolean filled;

	private Shape shape;
	private AffineTransform transform;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public Vector2<Float> getPos() {
		return pos;
	}
	
	public void setPos(Vector2<Float> pos) {
		transform.setToTranslation(pos.getX() - this.pos.getX(), pos.getY() - this.pos.getY());
		this.shape = transform.createTransformedShape(shape);
		this.pos = pos;
	}
	
	public void translate(Vector2<Float> translation) {
		transform.setToTranslation(translation.getX(), translation.getY());
		this.shape = transform.createTransformedShape(shape);
		this.pos = new Vector2<Float>(pos.getX() + translation.getX(), pos.getY() + translation.getY());
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean fill) {
		filled = fill;
	}

	public ShapeObject() {
		this.setPos(new Vector2<Float>(0f, 0f));
		this.shape = null;
		filled = false;
	}
	
	public ShapeObject(Shape shape, Color color, boolean fill) {
		set(shape, color, fill);
	}
	
	public void set(Shape shape, Color color, boolean fill) {
		transform = new AffineTransform();
		Shape tempShape = transform.createTransformedShape(shape);
		this.shape = tempShape;
		this.pos = new Vector2<Float>((float) tempShape.getBounds().x, (float) tempShape.getBounds().y);
		this.setColor(color);
		this.filled = fill;
	}



}
