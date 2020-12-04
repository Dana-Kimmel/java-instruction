package cc2_ArrowheadApp;

public class ArrowheadApp {

	public static void main(String[] args) {
		int input = Console.getInt("Enter a number");

		if (input % 2 == 0) {
			input++;
		}
		for (int row = 1; row <= input; row++) {
			if (row <= (input + 1) / 2) {
				for (int arrow = 1; arrow <= row; arrow++) {
					System.out.print(">");
				}
				System.out.println("");
			} else {
				for (int arrow = 1; arrow <= (input + 1) - row; arrow++) {
					System.out.print(">");
				}
				System.out.println("");
			}
		}
	}

}
