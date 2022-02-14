package main.graphics.objects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import global.math.Vector2;

public class ShapeObject {

	private String name;
	private Transform transform = new Transform();
	private Color color;
	private boolean filled;

	private Shape shape;
	private AffineTransform affineTransform;
	
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
		return transform.position();
	}
	
	public void setPos(Vector2<Float> pos) {
		//affineTransform.setToTranslation(pos.getX() - this.transform.position().getX(), pos.getY() - this.transform.position().getY());
		float x = pos.getX() - this.transform.position().getX();
		float y = pos.getY() - this.transform.position().getY();
//		System.out.println("Pos:\nx: " + this.transform.position().getX() + "\ny: " + this.transform.position().getY());
//		System.out.println("Translate:\nx: " + x + "\ny: " + y);
		affineTransform.setToTranslation(x, y);
		//affineTransform.transform(new Point2D.Float(this.transform.position().getX(), this.transform.position().getY()), new Point2D.Float(x, y));
		this.shape = affineTransform.createTransformedShape(this.shape);
		
		this.transform.position().set(new Vector2<Float>(this.transform.position().getX() + x, this.transform.position().getY() + y));

	}
	
	public void translate(Vector2<Float> translation) {
		affineTransform.translate(translation.getX(), translation.getY());
		this.shape = affineTransform.createTransformedShape(this.shape);
		this.transform.position().set(new Vector2<Float>(this.transform.position().getX() + translation.getX(), this.transform.position().getY() + translation.getY()));
	}
	
	public void rotate(float degrees, float offsetx, float offsety) {
		affineTransform.setToRotation(degrees * Math.PI/180, this.transform.position().getX() + offsetx, this.transform.position().getY() + offsety);
		//affineTransform.setToRotation(degrees * Math.PI/180);
		this.shape = affineTransform.createTransformedShape(this.shape);
		
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
		affineTransform = new AffineTransform();
		Shape tempShape = affineTransform.createTransformedShape(shape);
		this.shape = tempShape;
		this.transform.position().set(new Vector2<Float>((float) tempShape.getBounds().x, (float) tempShape.getBounds().y));
		this.setColor(color);
		this.filled = fill;
	}
}
