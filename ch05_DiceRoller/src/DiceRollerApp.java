
public class DiceRollerApp {
	private static int getDiceRoll() {
		int diceRoll = (int) (Math.random() * 6) + 1;
		return diceRoll;
	}

	private static void printExtraMessage(int dice1, int dice2) {
		if (dice1 + dice2 == 2) {
			System.out.println("Snake eyes!");
		} else if (dice1 + dice2 == 12) {
			System.out.println("Box cars!");
		}
	}

	public static void main(String[] args) {
		int dice1 = getDiceRoll();
		int dice2 = getDiceRoll();

		String message = "Die 1: " + dice1 + "\nDie 2: " + dice2 + "\nTotal: " + (dice1 + dice2);
		printExtraMessage(dice1, dice2);

		System.out.println(message);
	}

}
