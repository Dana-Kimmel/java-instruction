import java.text.NumberFormat;

public class Rectangle {

	// fields
	private double length;
	private double width;

	// constructors
	public Rectangle() {
		this.length = 0.0;
		this.width = 0.0;
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	// setters and getters
	public void setLength(double length) {
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public double calculateArea() {
		return width * length;
	}

	public String getAreaFormatted() {
		double area = this.calculateArea();
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberFormatted = number.format(area);
		return numberFormatted;
	}

	public double calculatePerimeter() {
		return (2 * width) + (2 * length);
	}

	public String getPerimeterFormatted() {
		double perimeter = this.calculatePerimeter();
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberFormatted = number.format(perimeter);
		return numberFormatted;
	}
}
