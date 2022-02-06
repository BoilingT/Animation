package global.math;

public class Vector2<T> {
	
	private T x;
	private T y;
	
	public Vector2() {
		this.x = null;
		this.y = null;
	}
	
	public Vector2(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public T getY() {
		return y;
	}
	
	public void set(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2<T> vec2) {
		this.x = vec2.getX();
		this.y = vec2.getY();
	}
	
	public String toString() {
		return "[x: " + this.getX() + ", y: " + this.getY()+ "]"; 
	}
}
