package kimmel.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCleanerApp {

	private static final String inputFilename = "prospect.csv";
	private static final String outputFilename = "prospect_clean.csv";

	public static void main(String[] args) {

		System.out.println("File Cleaner\n");

		try (BufferedReader in = new BufferedReader(new FileReader(inputFilename));
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)))) {

			String line = in.readLine();
			while (line != null) {
				Prospect p = createProspect(line);

				out.print(p.getFirstName());
				out.print(",");
				out.print(p.getLastName());
				out.print(",");
				out.print(p.getEmail());

				line = in.readLine();
			}

		} catch (IOException e) {
			System.err.println(e);

		}

		System.out.println("Source file: " + inputFilename);
		System.out.println("Cleaned file: " + outputFilename);
		System.out.println();
		System.out.println("Congratulations!");

	}

	public static Prospect createProspect(String csvStr) {
		String[] nameParts = csvStr.split(",");

		String emailAddress = nameParts[2].toLowerCase();
		String firstName = convertToTitleCase(nameParts[0]);
		String lastName = convertToTitleCase(nameParts[1]);

		Prospect prospect = new Prospect(firstName, lastName, emailAddress);

		return prospect;

	}

	public static String convertToTitleCase(String inputStr) {
		String firstNameTrimmed = inputStr.trim();
		String nameFirstLetter = firstNameTrimmed.substring(0, 1);
		nameFirstLetter = nameFirstLetter.toUpperCase();

		String nameAfterFirstLetter = firstNameTrimmed.substring(1);
		nameAfterFirstLetter = nameAfterFirstLetter.toLowerCase();

		String titleCase = nameFirstLetter + nameAfterFirstLetter;

		return titleCase;

	}
}
