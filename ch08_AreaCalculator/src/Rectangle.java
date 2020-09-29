
public class Rectangle extends Square {
	// fields

	private double height;

	// constructors
	public Rectangle(double width, double height) {
		super(width);
		this.height = height;
	}

	// getters and setters

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return this.getWidth() * height;
	}

}
