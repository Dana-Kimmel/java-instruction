package kimmel.app;

public class GuessingGameApp {

	public static void main(String[] args) {

		int numToGuess = NumberUtil.getRandomInt(100);

		int userGuess = 0;
		int numGuesses = 0;
		while (userGuess != numToGuess) {
			numGuesses++;
			userGuess = Console.getInt("Enter a number between 1 and 100: ", 1, 100);

			if (userGuess > (10 + numToGuess)) {
				System.out.println("Way to high!");
			} else if (userGuess > numToGuess) {
				System.out.println("Too high!");
			} else if (userGuess < (numToGuess - 10)) {
				System.out.println("Way too low!");
			} else if (userGuess < numToGuess) {
				System.out.println("Too low!");
			} else {
				System.out.println("You got it in " + numGuesses + " tries!");
			}
		}

	}

}
