package main.graphics;
import java.awt.geom.Line2D;

import global.math.*;
import main.graphics.Shapes;
import main.graphics.objects.ObjectCollection;

public class GraphicGeometry extends Drawing{

	private static GraphicGeometry instance = null;
	
	public static GraphicGeometry getInstance() {
		if (instance == null) {
			instance = new GraphicGeometry();
		}
		
		return instance;
	}
	
	private void addCollection() {
		
	}
	
	public void addTriangle(Vector3<Float> x, Vector3<Float> y, String name) {
		ObjectCollection collection = new ObjectCollection(name);
		//collection.add(new ShapeObject(Shapes.Line(x.getX(), y.getX()), ));
	}
	
	public void addLines(float[] x, float[] y, String name) {
		if (x.length - y.length == 0) {
			int length = x.length;
			for (int i = 0; i < length-1; i++) {
				addLine(new Vector2<Float>(x[i], y[i]), new Vector2<Float>(x[i+1], y[i+1]), name);			
			}
		}
	}
}
