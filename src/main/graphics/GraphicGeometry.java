package main.graphics;

import global.math.*;

public class GraphicGeometry extends Drawing{

	private static GraphicGeometry instance = null;
	
	public static GraphicGeometry getInstance() {
		if (instance == null) {
			instance = new GraphicGeometry();
		}
		
		return instance;
	}
	
	public void addTriangle(Vector3<Float> x, Vector3<Float> y, String name) {
		addLine(new Vector2<Float>(x.getX(), y.getX()), new Vector2<Float>(x.getY(), y.getY()), "");
		addLine(new Vector2<Float>(x.getY(), y.getY()), new Vector2<Float>(x.getZ(), y.getZ()), "");
		addLine(new Vector2<Float>(x.getZ(), y.getZ()), new Vector2<Float>(x.getX(), y.getX()), "");
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
