package shape;

public abstract class Shape {
	protected int x;
	protected int y;
	
	public Shape() {
	}
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//Abstract method
	public abstract double getArea();
	public abstract double getCircumn();
	
	public String getXY() {
		return x+" , "+y;
//		String result;
//		result = x+" , "+y;
//		return result;
	}
}
