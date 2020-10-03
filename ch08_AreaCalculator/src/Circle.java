
public class Circle extends Shape {
	// fields
	private double radius;

	// constructors
	public Circle(double radius) {
		this.radius = radius;
	}

	// getters and setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// overrides
	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	public double getPerimeter() {
		return Math.PI * (2 * radius);

	}
}
