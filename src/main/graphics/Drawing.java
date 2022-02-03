package main.graphics;

import java.awt.Color;
import java.util.ArrayList;

import global.math.Vector2;

public class Drawing {
	
	//Singleton
	private static Drawing instance = null;
	
	private static Color color = Color.black;
	private static boolean fill = false;
	private static ArrayList<ShapeObject> objects = new ArrayList<>();
	
	public Drawing() {
		
	}
	
	public static Drawing getInstance() {
		if (instance == null) {
			instance = new Drawing();
		}
		
		return instance;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public ArrayList<ShapeObject> getObjects(){
		return objects;
	}
	
	private void setObjects(ArrayList<ShapeObject> objects) {
		this.objects = objects;
	}
	
	public ShapeObject getObject(int index) {
		return objects.get(index);
	}
	
	public ShapeObject getObject(ShapeObject obj) {		
		return objects.get(objects.indexOf(obj));
	}
	
	private void addShape(ShapeObject obj) {
		objects.add(obj);
	}
	
	private void deleteShape(ShapeObject obj) {
		objects.remove(obj);
	}

	public ShapeObject addRect(Vector2<Float> pos, float width, float height, String name) {
		ShapeObject rect = new ShapeObject(Shapes.Rect(pos, width, height), color, fill);
		rect.setName(name);
		addShape(rect);
		return rect;
	}
	
	public ShapeObject addArc(Vector2<Float> pos, float width, float height, String name) {
		ShapeObject arc = new ShapeObject(Shapes.Arc(pos, width, height), color, fill);
		arc.setName(name);
		addShape(arc);
		return arc;
	}
}
