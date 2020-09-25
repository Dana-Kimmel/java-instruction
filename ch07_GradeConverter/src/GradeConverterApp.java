
public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter\n");
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			// get input from user
			int numberGrade = Console.getInt("Enter numerical grade: ");
			Grade letterGrade = new Grade(numberGrade);
			System.out.println("Letter grade: " + letterGrade.getLetter());

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ", "y", "n");

		}
	}
}