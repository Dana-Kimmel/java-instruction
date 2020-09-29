
public class AreaCalculatorApp {

	private static void printArea(String shapeName, Shape shape) {
		System.out.println("The area of the " + shapeName + " you entered is " + shape.getArea());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String csr = Console.getString("Calculate area of circle, square or rectangle? (c/s/r)");

			switch (csr) {
			case "c":
			case "C":
				double radius = Console.getDouble("Enter radius: ");
				Circle circle = new Circle(radius);
				// System.out.println("The area of the circle you entered is " +
				// circle.getArea());(used printArea)
				printArea("Circle", circle);
				break;

			case "s":
			case "S":
				double squareWidth = Console.getDouble("Enter width: ");
				Square square = new Square(squareWidth);
				// System.out.println("The area of the square you entered is " +
				// square.getArea());(used printArea)
				printArea("Square", square);
				break;

			case "r":
			case "R":
				double height = Console.getDouble("Enter height: ");
				double rectangleWidth = Console.getDouble("Enter width: ");
				Rectangle rectangle = new Rectangle(height, rectangleWidth);
				// System.out.println("The area of the rectangle you entered is " +
				// rectangle.getArea());(used printArea)
				printArea("Rectangle", rectangle);
				break;
			}

			choice = Console.getString("Continue? (y/n)");

		}

	}
}