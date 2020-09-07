import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the letter grade converter");
		Scanner sc = new Scanner(System.in);

		// while loop - loop while 'choice ' == 'y'
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get the numerical grade
			System.out.print("Enter numerical grade: ");
			int numericalGrade = sc.nextInt();
			String letterGrade = " ";

			// convert to letter grade
			if (numericalGrade >= 88) {
				letterGrade = "A";
			} else if (numericalGrade >= 80) {
				letterGrade = "B";
			}

			else if (numericalGrade >= 67) {
				letterGrade = "C";
			}

			else if (numericalGrade >= 60) {
				letterGrade = "D";
			}

			else {
				letterGrade = "F";
			}

			System.out.println("letter Grade: " + letterGrade);

			System.out.println("Continue");

			choice = sc.next();
		}

		System.out.println("bye");
	}
}
