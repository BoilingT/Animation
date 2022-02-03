package global.math;

public class Vector3<T> extends Vector2<T>{
	
	private T z;
	
	public Vector3() {
		
	}
	
	public Vector3(T x, T y, T z) {
		super(x, y);
		this.z = z;
	}

	public T getX() {
		return super.getX();
	}

	public T getY() {
		return super.getY();
	}

	public T getZ() {
		return z;
	}
	
	public String toString() {
		return "[x: " + this.getX() + ", y: " + this.getY() + ", z: " + this.getZ() + "]"; 
	}
	
	
}
