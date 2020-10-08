package kimmel.app;

public class StringApp {

	public static void main(String[] args) {
		// length of "java" is 4 using .length
		String productCode = "java";
		System.out.println("Length of " + productCode + " is" + productCode.length());

		// finds first space in string using .indexOf
		String name = "Martin Van Buren";
		int firstSpace = name.indexOf(" ");
		System.out.println("Found first space at index " + firstSpace);
		// finds second space in string
		int secondSpace = name.indexOf(" ", firstSpace + 1);
		System.out.println("Found second space at index " + secondSpace);
		// no 3rd space will return -1, , no -1 in index
		int thirdSpace = name.indexOf(" ", secondSpace + 1);
		System.out.println("Found third space at index " + thirdSpace);

		// find 4th character using .charAt
		char fifthChar = name.charAt(4);
		System.out.println("The fifth charachter is " + fifthChar);

		// remove spaces front back with .trim
		String strWithSpaces = "  a  b c ";
		String trimmed = strWithSpaces.trim();
		System.out.println("Trimmed = [" + trimmed + "]");

		//
		String fullName = "Mike Murach";
		int spaceIndex = fullName.indexOf(" ");
		String firstName = fullName.substring(0, spaceIndex);
		String lastName = fullName.substring(spaceIndex + 1);
		System.out.println("firstName = [" + firstName + "] lastName = [" + lastName + "]");

		//
		String phoneNumber = "937-123-4567";
		String dotPhoneNumber = phoneNumber.replace("-", ".");
		System.out.println("dotPhoneNumber =  " + dotPhoneNumber);

		// split on spaces with .split
		String firstNames = "Dave Michael John Carl";
		String[] firstNamesArray = firstNames.split(" ");
		System.out.println("firstNamesArray length = " + firstNamesArray.length);
		for (String f : firstNamesArray) {
			System.out.println("[" + f + "]");
		}

	}
}
