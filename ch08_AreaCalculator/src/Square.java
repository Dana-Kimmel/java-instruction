
public class Square extends Shape {
	// fields
	private double width;

	// constructors
	public Square(double width) {
		this.width = width;
	}

	// getters and setters
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getArea() {
		return width * width;
		// or Math.pow(width, 2.0);
	}

	public double getPerimeter() {
		return 4 * width;
	}

}
