package kimmel.ui;

import kimmel.business.Grade;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter");

		Grade grade = new Grade();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			int numbergrade = Console.getInt("Enter numerical grade: ");

			grade.setNumber(numbergrade);

			String letterGrade = grade.getLetter();

			System.out.println("Letter grade: " + letterGrade);
			System.out.println();

			choice = Console.getString("Continue? (y/n) ", "y", "n");
		}

	}

}
