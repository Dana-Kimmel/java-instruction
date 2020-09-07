import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		System.out.println("Student Registration Form");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String firstName;
		String lastName;
		int birthYear;

		System.out.print("Enter your first name: ");
		firstName = sc.next();

		System.out.print("Enter your last name:");
		lastName = sc.next();

		System.out.print("Enter your birth year:");
		birthYear = sc.nextInt();

		// biz logic
		String tempPwd = "*" + birthYear;

		System.out.println("Welcome" + "  " + firstName + "  " + lastName + "!");
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is:  " + tempPwd);

		System.out.println("Bye");

	}

}
